
package com.javaboy.common.controller.redis;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author zhangxu12
 * @version 1.0
 * @date 2022/2/8 17:09
 * key自定义，val是token，100为时间戳
    stringRedisTemplate.opsForZSet().add("key","val",100);
    结果为null或者0表示token不存在
    stringRedisTemplate.opsForZSet().rank("key","val");
    删除固定token
    stringRedisTemplate.opsForZSet().remove("key","val");
 */
public class TestScore {
    public static void main(String[] args) throws InterruptedException {
        Set<Long> set=new HashSet<>();
        for (int i=0;i<10;i++) {
            set.add(System.currentTimeMillis());
            Thread.sleep(1000L);
        }
        set.stream().forEach(System.out::println);
        System.out.println("1");
        long now =System.currentTimeMillis()-5000;
        //删除之前5秒的数据
        Iterator<Long> it = set.iterator();
        for(int i=0; i<set.size(); i++){
            Long ival = it.next();
            if (ival <now) {
                it.remove();
                i--;
            }
        }
        System.out.println("2");
        set.stream().forEach(System.out::println);

    }
}
