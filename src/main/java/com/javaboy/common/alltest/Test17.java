package com.javaboy.common.alltest;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.javaboy.common.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author : zyf
 * @date : 2022/9/9 15:05
 */
public class Test17 {
    /**
     * 断言测试
     */
    @Test
    public void test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        Assert.notNull(list, "查询列表数据不能为空");
    }

    @Test
    public void test1() {
        Long aLong = new Long(99L);
        Integer integer = new Integer(100);
        if (aLong > integer) {
            System.out.println(123);
        }
    }

    @Test
    public void test2() {
        String name = "sg-6666667778666666777866666677786666667778666666777866666677786666";
        String finalName = "sg-" + name;
        System.out.println(finalName.length());
        System.out.println(name.length());
    }

    @Test
    public void test3() {
        String format = String.format("dhcp服务的ip[%s]应该在dhcp池范围内", "123");
        System.out.println(format);
    }

    @Test
    public void test4() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("13");
        strings.add("32");
        strings.add("2");
        String s = strings.stream().skip(RandomUtil.randomInt(0, strings.size())).findAny().orElseThrow(() -> new RuntimeException("没有合适的数据"));
        System.out.println(s);


    }

    @Test
    public void test5() {
        User user = new User();
        user.setAge(4);
        User user1 = new User();
        user1.setAge(8);
        User user2 = new User();
        user2.setAge(8);
        List<User> users = Lists.newArrayList(user, user1, user2);
        User user3 = users.stream().reduce((a, b) -> a.setAge((a.getAge() + b.getAge()) / 2)).orElseThrow(() -> new RuntimeException("数据异常"));
        System.out.println(user3);

    }

    @Test
    public void test6() {
        List<Integer> deployedStatus = new ArrayList<>(getDeployedStatus());
        deployedStatus.add(8);
        deployedStatus.remove(3);
        System.out.println(deployedStatus.size());
    }


    public static List<Integer> getDeployedStatus() {
        return Arrays.asList(1, 2, 3, 4, 6, 7);
    }

    @Test
    public void test7() {
        List<User> users = new ArrayList<>();
        users.add(new User().setName("zhangsan").setEmail("123"));
        users.stream().filter(l -> 0 != l.getAge()).forEach(l -> System.out.println(l));
    }

    @Test
    public void test8() {
        System.out.println("开始");

        CompletableFuture.runAsync(() -> {
            System.out.println(123);
            throw new RuntimeException("运行异常");
        });
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("123");

    }

    @Test
    public void test9(){
        List<String> list = Lists.newArrayList("P1e7e945c47d45128b5ce712ecb1fdf2","Vbac3d10661f4da3a6697ed2703ef6b9","G240537eac9a47ae9a2debf082f0005d","L27a78175f234cf6bf0f4e3c94f1e131","S7fa70de86b4437c91f13d836ed7aca3");
        for (String s : list) {
            System.out.println(s);
            if(StrUtil.startWithAny(s,"G","S","P","V","W")){
                System.out.println(s);
            }
        }
    }

    @Test
    public void test10(){
        String a="[\n" +
                "    {\n" +
                "        \"cloudId\": \"6f568c65-9052-4a9a-b755-391ccbd01f33\",\n" +
                "        \"deviceId\": \"V4dce3e9b32c43a5ac86603fc197f685\",\n" +
                "        \"deviceName\": \"虚拟机2\",\n" +
                "        \"deviceType\": \"VM\",\n" +
                "        \"hostIp\": \"192.168.2.108\",\n" +
                "        \"id\": \"P1058f4e68124eddad580ddac516c14a\",\n" +
                "        \"ips\": [\n" +
                "            {\n" +
                "                \"cidr\": \"192.168.0.0/24\",\n" +
                "                \"cloudSegmentId\": \"8cea298c-a52d-4891-b7a7-80d249286898\",\n" +
                "                \"cloudSubnetId\": \"47c308f8-bd8e-4866-8c3e-40fd2f235a66\",\n" +
                "                \"gatewayIp\": \"192.168.0.1\",\n" +
                "                \"ipAddress\": \"192.168.0.2\",\n" +
                "                \"ipVersion\": 4,\n" +
                "                \"networkType\": \"vlan\",\n" +
                "                \"segmentId\": \"Gbaeb771c53249c3af5227a46f8314df\",\n" +
                "                \"subnetId\": \"Sbba52d390d04b0e8f684a6aa92e421c\",\n" +
                "                \"tag\": 303\n" +
                "            }\n" +
                "        ],\n" +
                "        \"macAddress\": \"fa:16:3e:4f:cd:d4\",\n" +
                "        \"name\": \"eth\",\n" +
                "        \"networkId\": \"N24cd51a15f349b8b98fbb3ca2d39636\",\n" +
                "        \"onlyForAccess\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"cloudId\": \"6f568c65-9052-4a9a-b755-391ccbd01f33\",\n" +
                "        \"deviceId\": \"V4dce3e9b32c43a5ac86603fc197f685\",\n" +
                "        \"deviceName\": \"虚拟机2\",\n" +
                "        \"deviceType\": \"VM\",\n" +
                "        \"hostIp\": \"192.168.2.108\",\n" +
                "        \"id\": \"P1058f4e68124eddad580ddac516c14a\",\n" +
                "        \"ips\": [\n" +
                "            {\n" +
                "                \"cidr\": \"192.168.0.0/24\",\n" +
                "                \"cloudSegmentId\": \"8cea298c-a52d-4891-b7a7-80d249286898\",\n" +
                "                \"cloudSubnetId\": \"47c308f8-bd8e-4866-8c3e-40fd2f235a66\",\n" +
                "                \"gatewayIp\": \"192.168.0.1\",\n" +
                "                \"ipAddress\": \"192.168.0.2\",\n" +
                "                \"ipVersion\": 4,\n" +
                "                \"networkType\": \"vlan\",\n" +
                "                \"segmentId\": \"Gbaeb771c53249c3af5227a46f8314df\",\n" +
                "                \"subnetId\": \"Sbba52d390d04b0e8f684a6aa92e421c\",\n" +
                "                \"tag\": 303\n" +
                "            }\n" +
                "        ],\n" +
                "        \"macAddress\": \"fa:16:3e:4f:cd:d4\",\n" +
                "        \"name\": \"eth\",\n" +
                "        \"networkId\": \"N24cd51a15f349b8b98fbb3ca2d39636\",\n" +
                "        \"onlyForAccess\": false\n" +
                "    }\n" +
                "]";
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(a);

            // 遍历数组中的每个对象
            for (JsonNode objectNode : jsonNode) {
                // 替换 hostIp 字段的值
                ((com.fasterxml.jackson.databind.node.ObjectNode) objectNode).put("hostIp", "123");
            }
            // 将修改后的 JSON 对象转换回字符串
            String modifiedJsonString = mapper.writeValueAsString(jsonNode);
            System.out.println(modifiedJsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }



}
