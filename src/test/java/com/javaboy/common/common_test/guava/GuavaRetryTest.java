package com.javaboy.common.common_test.guava;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.javaboy.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author zyf
 * @date 2023/7/20 15:19
 */
@SpringBootTest
@Slf4j
public class GuavaRetryTest {

    @Test
    public void test() {
        try {
            Callable<User> callable = () -> {
                // do something useful here
                System.out.println(123);
                User user = new User();
                user.setAge(5);
                return user;
            };
            Retryer<User> retryer = RetryerBuilder.<User>newBuilder()
//                .retryIfResult(Predicates.<Boolean>alwaysTrue())
                    .retryIfResult(user -> {
                        Integer age = user.getAge();
                        if (user.getAge() > 5) {
                            return false;
                        }
                        return true;
                    })
//                    .retryIfExceptionOfType(IOException.class)
//                    .retryIfRuntimeException()
                    .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                    .withWaitStrategy(WaitStrategies.fixedWait(10, TimeUnit.SECONDS))
                    .build();
            retryer.call(callable);
        } catch (Exception e) {
            log.error("重试好多次还是失败了:{}", e.getMessage());
//            e.printStackTrace();
        }

        System.out.println("continue");
    }

}
