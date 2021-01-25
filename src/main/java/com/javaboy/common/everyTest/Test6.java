package com.javaboy.common.everyTest;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yayu
 * @title: Test5
 * @description: TODO
 * @date 2021/1/21 15:07
 */
@RestController
@RequestMapping("/test6")
public class Test6 {
    @RequestMapping("/session")
    public Map test(HttpServletRequest request, String userId){
        String localIp = request.getRemoteAddr();
        if(null !=userId){
            HttpSession session = (HttpSession) request.getSession().getAttribute(userId);
            if(null !=session){
                String ip = (String) session.getAttribute("ip");
                Enumeration<String> em = session.getAttributeNames();
                if(StrUtil.isNotEmpty(ip)&& !localIp.equals(ip)){
                    System.out.println(session.getAttribute("ip")+"小子号被迫下线");
                    while(em.hasMoreElements()){
                        request.getSession().removeAttribute(em.nextElement().toString());
                    }
                }
            }
        }
        request.getSession().setAttribute(userId,request.getSession());
        request.getSession().setAttribute("ip",localIp);
        return new HashMap(){{
            put("code","200");
        }};
    }

}
