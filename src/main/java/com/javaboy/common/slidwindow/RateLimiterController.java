package com.javaboy.common.slidwindow;

import com.javaboy.common.annotations.RateLimiter;
import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.constant.CodeConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zyf
 * @date : 2022/9/9 15:46
 */
@RestController
@RequestMapping("/rateLimiter")
public class RateLimiterController {

    @RateLimiter(time = 60, count = 1, limitType = "0.0.0.0", limitMsg = "一分钟内只能请求一次，请稍后重试")
    @GetMapping("/hello")
    public ResponseMsg hello() {
        return new ResponseMsg(CodeConstant.SUCCESS,CodeConstant.SUCCESS_DESC,"查询成功~~~~~~~~~");
    }

}
