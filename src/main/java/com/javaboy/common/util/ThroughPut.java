package com.javaboy.common.util;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.util.StringTokenizer;

/**
 * @author: zyf  获取网络云吞吐 上行速率 下行速率
 * @create: 2021-11-01 16:15
 **/
@Slf4j
public class ThroughPut {
    private static final int SLEEP_TIME = 1000 * 60 * 9;

    public String getThroughPut(){
        String throughput = "";
        if (isWindowsOrLinux().equals("windows")) {
            throughput = getNetworkThroughputForWindows();
        } else {
            throughput = getNetworkThroughputForLinux();
        }
        return throughput;
    }

    public String isWindowsOrLinux() {
        String osName = System.getProperty("os.name");
        String sysName = "";
        if (osName.toLowerCase().startsWith("windows")) {
            sysName = "windows";
        } else if (osName.toLowerCase().startsWith("linux")) {
            sysName = "linux";
        }
        return sysName;
    }

    public String getNetworkThroughputForWindows() {
        Process pro1 = null;
        Process pro2 = null;
        Runtime r = Runtime.getRuntime();
        BufferedReader input = null;
        String rxPercent = "";
        String txPercent = "";
        JSONObject jsonObject = new JSONObject();
        try {
            String command = "netstat -e";
            pro1 = r.exec(command);
            input = new BufferedReader(new InputStreamReader(pro1.getInputStream()));
            String result1[] = readInLine(input, "windows");
            pro2 = r.exec(command);
            input = new BufferedReader(new InputStreamReader(pro2.getInputStream()));
            String result2[] = readInLine(input, "windows");
            rxPercent = formatNumber((Long.parseLong(result2[0]) - Long.parseLong(result1[0]))
                    / (float) (1024 * 1024 * (SLEEP_TIME / 1000)));
            txPercent = formatNumber((Long.parseLong(result2[1]) - Long.parseLong(result1[1]))
                    / (float) (1024 * 1024 * (SLEEP_TIME / 1000)));
            input.close();
            pro1.destroy();
            pro2.destroy();
        } catch (Exception e) {

        }
        jsonObject.put("rxPercent", rxPercent); // 下行速率
        jsonObject.put("txPercent", txPercent); // 上行速率
        return JSON.toJSONStringWithDateFormat(jsonObject, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue);
    }



    public String[] readInLine(BufferedReader input, String osType) {
        String rxResult = "";
        String txResult = "";
        StringTokenizer tokenStat = null;
        try {
            if (osType.equals("linux")) { // 获取linux环境下的网口上下行速率
                String result[] = input.readLine().split(" ");
                int j = 0, k = 0;
                for (int i = 0; i < result.length; i++) {
                    if (result[i].indexOf("RX") != -1) {
                        j++;
                        if (j == 2) {
                            rxResult = result[i + 1].split(":")[1];
                        }
                    }
                    if (result[i].indexOf("TX") != -1) {
                        k++;
                        if (k == 2) {
                            txResult = result[i + 1].split(":")[1];
                            break;
                        }
                    }
                }

            } else { // 获取windows环境下的网口上下行速率
                input.readLine();
                input.readLine();
                input.readLine();
                input.readLine();
                tokenStat = new StringTokenizer(input.readLine());
                tokenStat.nextToken();
                rxResult = tokenStat.nextToken();
                txResult = tokenStat.nextToken();
            }
        } catch (Exception e) {
        }
        String arr[] = { rxResult, txResult };
        return arr;
    }



    /**
     * 格式化浮点数(float 和 double)，保留两位小数
     *
     * @param obj
     * @return
     */
    private String formatNumber(Object obj) {
        String result = "";
        if (obj.getClass().getSimpleName().equals("Float")) {
            result = new Formatter().format("%.2f", (float) obj).toString();
        } else if (obj.getClass().getSimpleName().equals("Double")) {
            result = new Formatter().format("%.2f", (double) obj).toString();
        }
        return result;
    }

    /**
     * 获取Linux环境下网口的上下行速率
     *
     * @return
     */
    public String getNetworkThroughputForLinux() {
        Process pro1 = null;
        Process pro2 = null;
        Runtime r = Runtime.getRuntime();
        BufferedReader input = null;
        String rxPercent = "";
        String txPercent = "";
        JSONObject jsonObject = new JSONObject();
        try {
            String command = "watch ifconfig";
            pro1 = r.exec(command);
            input = new BufferedReader(new InputStreamReader(pro1.getInputStream()));

            String result1[] = readInLine(input, "linux");
            Thread.sleep(SLEEP_TIME);
            pro2 = r.exec(command);
            input = new BufferedReader(new InputStreamReader(pro2.getInputStream()));
            String result2[] = readInLine(input, "linux");
            rxPercent = formatNumber((Long.parseLong(result2[0]) - Long.parseLong(result1[0]))
                    / (float) (1024 * 1024 * (SLEEP_TIME / 1000))); // 下行速率(MB/s)
            txPercent = formatNumber((Long.parseLong(result2[1]) - Long.parseLong(result1[1]))
                    / (float) (1024 * 1024 * (SLEEP_TIME / 1000))); // 上行速率(MB/s)
            input.close();
            pro1.destroy();
            pro2.destroy();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        jsonObject.put("rxPercent", rxPercent); // 下行速率
        jsonObject.put("txPercent", txPercent); // 上行速率
        return JSON.toJSONStringWithDateFormat(jsonObject, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue);
    }



}
