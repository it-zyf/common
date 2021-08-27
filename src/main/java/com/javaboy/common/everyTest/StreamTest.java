package com.javaboy.common.everyTest;

import com.javaboy.common.entity.Bean;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 通过Stream流找出集合中对象中某个属性重复的值.
 *
 * @author: zyf
 * @create: 2021-08-27 10:12
 **/
public class StreamTest {
    public static void main(String[] args) {
        ArrayList<Bean> list = new ArrayList<>();
        Bean b1 = new Bean("200021", "张三", "男");
        Bean b2 = new Bean("200025", "李四", "女");
        Bean b3 = new Bean("200023", "王二麻子", "男");
        Bean b4 = new Bean("200021", "狗蛋", "男");
        Bean b5 = new Bean("200026", "哈皮", "女");
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        List<String> repeatCode = list.stream().collect(Collectors.groupingBy(Bean::getCode, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("repeatCode = " + repeatCode);
        System.out.println("list = " + list);
        if (CollectionUtils.isNotEmpty(repeatCode)) {
            repeatCode.forEach(merId -> extractRepeat(list, merId));
        }
        System.out.println("list = " + list);
    }

    public static void extractRepeat(List<Bean> compInfos, String repeatCode) {
        Optional<Bean> first = compInfos.stream().filter(o -> o.getCode().equals(repeatCode)).findFirst();
        if (first.isPresent()) {
            Bean bean = first.get();
            compInfos.removeIf(next -> next.getCode().equals(repeatCode));//先将所有符合这个重复的code的对象从源集合中删除.
            compInfos.add(bean);//再将取出来的第一个添加进去.
        }
    }


}
