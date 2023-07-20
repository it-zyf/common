package com.javaboy.common.common_test.guava;

import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.javaboy.common.entity.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author zyf
 * @date 2023/7/20 15:19
 */
@SpringBootTest
public class GuavaRetryTest {

    @Test
    public void test(){
        Callable<User> callable = () -> {
            // do something useful here
            System.out.println(123);
            User user = new User();
            user.setAge(5);
            return user;
        };
        Retryer<User> retryer = RetryerBuilder.<User>newBuilder()
                .retryIfResult(user -> user.getAge()<10)
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
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
