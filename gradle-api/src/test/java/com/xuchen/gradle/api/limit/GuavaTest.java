package com.xuchen.gradle.api.limit;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 基于令牌桶算法单机限流的demo
 */
@Slf4j
public class GuavaTest {
    public static void main(String[] args) {
        //线程池
        ExecutorService exec = Executors.newFixedThreadPool(10);
        //速率是每秒只有3个许可
        final RateLimiter rateLimiter = RateLimiter.create(3);

        for (int i = 0; i < 100; i++) {
            final int no = i;
            //执行线程
            exec.execute(() -> {
                try {
                    //获取许可
                    rateLimiter.acquire();
                    log.info("Accessing: " + no);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        //退出线程池
        exec.shutdown();
    }
}
