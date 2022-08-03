package com.javaboy.common.util;

/**
 * @author: zyf
 * @create: 2022-06-06 13:50
 **/

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.constant.CodeConstant;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

/**
 * 转换对象工具
 *
 * @author bugpool
 */
public class BeanConvertUtils extends BeanUtils {

    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier) {
        return convertTo(source, targetSupplier, null);
    }

    /**
     * 转换对象
     *
     * @param source         源对象
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象
     */
    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        if (null == source || null == targetSupplier) {
            return null;
        }

        T target = targetSupplier.get();
        copyProperties(source, target);
        if (callBack != null) {
            callBack.callBack(source, target);
        }
        return target;
    }

    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier) {
        return convertListTo(sources, targetSupplier, null);
    }

    /**
     * 整合了mybatisPlus page 分页.
     * @param sources
     * @param targetSupplier
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> Page<T> convertPageTo(Page<S> sources, Supplier<T> targetSupplier) {
        return convertPageTo(sources, targetSupplier, null);
    }

    public static <S, T> Page<T> convertPageTo(Page<S> sources, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        List<S> records = sources.getRecords();
        Page<T> sPage = new Page<>();
        sPage.setTotal(sources.getTotal());
        sPage.setSize(sources.getSize());
        sPage.setCurrent(sources.getCurrent());
        sPage.setOptimizeCountSql(sources.optimizeCountSql());
        sPage.setPages(sources.getPages());
        if (CollUtil.isEmpty(records)) {
            return sPage;
        }
        List<T> list = new ArrayList<>(records.size());
        for (S source : records) {
            T target = targetSupplier.get();
            copyProperties(source, target);
            if (callBack != null) {
                callBack.callBack(source, target);
            }
            list.add(target);
        }
        return sPage.setRecords(list);

    }

    public static <S, T> ResponseMsg<T> convertPageToR(Page<S> sources, Supplier<T> targetSupplier) {
        return convertPageToR(sources, targetSupplier, null);
    }

    public static <S, T> ResponseMsg<T> convertPageToR(Page<S> sources, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        List<S> records = sources.getRecords();

        HashMap<String, Object> map = new HashMap<>(16);
        if (CollUtil.isEmpty(records)) {
            return new ResponseMsg(CodeConstant.SUCCESS, CodeConstant.SUCCESS_DESC, Collections.emptyList());
        }

        List<T> list = new ArrayList<>(records.size());
        for (S source : records) {
            T target = targetSupplier.get();
            copyProperties(source, target);
            if (callBack != null) {
                callBack.callBack(source, target);
            }
            list.add(target);
        }

        map.put("pageSize", sources.getSize());

        //页码
        map.put("pageNo", sources.getCurrent());

        //数据结果集合
        map.put("dataList", list);

        //总页数
        map.put("totalPage", sources.getPages());

        //总记录数
        map.put("totalRecord", sources.getTotal());

        return new ResponseMsg(CodeConstant.SUCCESS, CodeConstant.SUCCESS_DESC, map);

    }






    /**
     * 转换对象
     *
     * @param sources        源对象list
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象list
     */
    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        if (null == sources || null == targetSupplier) {
            return Collections.emptyList();
        }

        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T target = targetSupplier.get();
            copyProperties(source, target);
            if (callBack != null) {
                callBack.callBack(source, target);
            }
            list.add(target);
        }
        return list;
    }





    /**
     * 回调接口
     *
     * @param <S> 源对象类型
     * @param <T> 目标对象类型
     */
    @FunctionalInterface
    public interface ConvertCallBack<S, T> {
        void callBack(S t, T s);
    }
}
