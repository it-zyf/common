package com.javaboy.common.alltest;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.system.HostInfo;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;
import org.junit.Test;
import oshi.hardware.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yayu
 * @title: Test7
 * @description: TODO
 * @date 2021/1/25 16:51
 */
public class Test7 {
    @Test
    public void test() {
        HashMap<String, String> map = new HashMap<>();
        map.put("张三", "123");
        map.put("张三", "456");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
//            System.out.println(entry.getValue());
        }

        Integer a = 10000;
        Integer b = 10000;
//        System.out.println(a.equals(b));

        CpuInfo cpuInfo = OshiUtil.getCpuInfo();
//        System.out.println(cpuInfo);
        //用户使用率
        double used = cpuInfo.getUsed();
//        System.out.println(used);
//        double used = cpuInfo.getUsed();
//        System.out.println(SystemUtil.getRuntimeInfo());
//        System.out.println(SystemUtil.getUserInfo());

//        CpuInfo cpuInfo = OshiUtil.getCpuInfo();
//        double used = cpuInfo.getUsed();
//        System.out.println(used);

        GlobalMemory memory = OshiUtil.getMemory();
        //内存使用量
//        long total = memory.getTotal();
//        long available = memory.getAvailable();
//        double div = NumberUtil.div(available,total)*100;
//        String divS=NumberUtil.roundStr(div,2);
//        System.out.println(divS+"%");

//        String s = Trans.FormetFileSize(available);
//        System.out.println(s);
//        System.out.println(total);
//        System.out.println(available);
        //磁盘空间
        List<HWDiskStore> diskStores = OshiUtil.getDiskStores();
        for (HWDiskStore diskStore : diskStores) {
//            long currentQueueLength = diskStore.getCurrentQueueLength();
//            long size = diskStore.getTimeStamp();
//            String s = Trans.FormetFileSize(size);
//            String s1 = Trans.FormetFileSize(currentQueueLength);
//            System.out.println(s);
//            System.out.println(s1);

//            long writes = diskStore.getWrites();
//            long reads = diskStore.getReads();
//            System.out.println(writes);
//            System.out.println(reads);
        }

        HardwareAbstractionLayer hardware = OshiUtil.getHardware();
        GlobalMemory memory1 = hardware.getMemory();
        CentralProcessor processor = hardware.getProcessor();
//        System.out.println(processor);

        //网络
        DecimalFormat df = new DecimalFormat("#.00");
        List<NetworkIF> networkIFs = OshiUtil.getNetworkIFs();
        if(CollUtil.isNotEmpty(networkIFs)){
            for (NetworkIF networkIF : networkIFs) {
                System.out.println(networkIF);
//                long bytesSent = networkIF.getBytesSent();
//                String sent = df.format((double) bytesSent / 1024) + "K";
//                System.out.println(sent);
//                long bytesRecv = networkIF.getBytesRecv();
//                String recv = df.format((double) bytesRecv / 1024) + "K";
//                System.out.println(recv);
            }

        }
//        System.out.println(hardware);
        HostInfo hostInfo = SystemUtil.getHostInfo();
        String address = hostInfo.getAddress();
        System.out.println(address);
//
//        System.out.println(memory);
    }


}
