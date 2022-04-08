package com.javaboy.common.alltest;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.javaboy.common.constant.CodeConstant;
import com.javaboy.common.exception.CustomException;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

/**
 *  用线程池+ FutureTask将1个查询拆分成多个小查询 选择FutureTask是因为它具有仅执行1次run()方法的特性(即使有多次调用也只执行1次)
 * ，避免了重复查询的可能。而且多任务异步执行也能提高接口响应速度。
 *
 * @author: zyf
 * @create: 2022-03-02 10:18
 **/
@RestController
@RequestMapping("test15")
public class Test15 {
    //线程池最好作为全局变量, 若作为局部变量记得用完后shutdown()
    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-start-runner-%d").build();
    ExecutorService taskExe= new ThreadPoolExecutor(10,20,800L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(100),namedThreadFactory);

    int count=0;

    @Test
    public void test() {

        //任务列表
        List<FutureTask<Integer>> taskList=new ArrayList<FutureTask<Integer>>();
        for(int i=0;i<100;i++){
            //创建100个任务放入【任务列表】
            FutureTask<Integer> futureTask=new FutureTask<Integer>(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return 2;
                }
            });
            //执行的结果装回原来的FutureTask中,后续直接遍历集合taskList来获取结果即可
            taskList.add(futureTask);
            taskExe.submit(futureTask);
        }
        //获取结果
        try{
            for(FutureTask<Integer> futureTask:taskList){
                count+=futureTask.get();
            }
        } catch (InterruptedException e) {
            System.out.println("线程执行被中断");
        } catch (ExecutionException e) {
            System.out.println("线程执行出现异常");
        }
        //关闭线程池
        taskExe.shutdown();
        //打印: 100
        System.out.println(count);
    }

    @Test
    public void test2() {
        ArrayList<String> list =new ArrayList<>();
        if(list==null){
            System.out.println(123);
        }
        Optional.ofNullable(list).orElse(new ArrayList<>()).forEach(s -> {
            System.out.println(11);
        });
    }
    @RequestMapping("/test")
    public String test3() {
        ArrayList<String> list = new ArrayList<>();
        Assert.notNull(list,"查询列表数据不能为空");
        return "ok";
    }

    @RequestMapping("/test2")
    public String test4() throws CustomException {
        ArrayList<String> list = new ArrayList<>();
        if(CollUtil.isEmpty(list)){
            throw new CustomException(CodeConstant.FAIL,"数据异常");
        }
        return "ok";
    }




    @RequestMapping(value = "/getLoginQr" ,method = RequestMethod.GET)
    public void createCodeImg(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");

        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        try {
            //这里没啥操作 就是生成一个UUID插入 数据库的表里
            String uuid = IdUtil.simpleUUID();
            response.setHeader("uuid", uuid);
            // 这里是开源工具类 hutool里的QrCodeUtil
            // 网址：http://hutool.mydoc.io/
            QrCodeUtil.generate(uuid, 300, 300, "jpg",response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
