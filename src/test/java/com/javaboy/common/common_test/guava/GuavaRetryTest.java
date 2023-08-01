package com.javaboy.common.common_test.guava;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import com.javaboy.common.entity.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author zyf
 * @date 2023/7/20 15:19
 */
@SpringBootTest
public class GuavaRetryTest {

    @Test
    public void test(){
        Callable<Boolean> callable = () -> {
            // do something useful here
            System.out.println(123);
            User user = new User();
            user.setAge(5);
            return true;
        };
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfResult(Predicates.<Boolean>alwaysTrue())
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .withWaitStrategy(WaitStrategies.fixedWait(10,TimeUnit.SECONDS))
                .build();
        try {
            retryer.call(callable);
        } catch (RetryException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
