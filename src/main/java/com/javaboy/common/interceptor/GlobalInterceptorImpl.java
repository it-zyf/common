package com.javaboy.common.interceptor;

import com.javaboy.common.entity.User;
import com.javaboy.common.util.ThreadLocalUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : zyf
 * @date : 2022/5/24 11:32
 */
@Component
public class GlobalInterceptorImpl implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setEmail("7876677@qq.com");
        ThreadLocalUtil.set("user",user);
        return true;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) {
        ThreadLocalUtil.remove();
    }
}
