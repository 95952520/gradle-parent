package com.xuchen.gradle.api.limit;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author xuchen
 * 信号量限流
 */
@Slf4j
public class CountLimitTest {

    //信号量，只允许 5个线程同时访问
    private static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) throws InterruptedException {
        //线程池，本demo为20个并发线程
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int no = i;
            //执行线程
            exec.execute(() -> {
                if (semaphore.getQueueLength() > 10) {
                    log.info("当前等待排队的任务数大于10，请等待");
                }
                try {
                    //获取许可
                    semaphore.acquire();
                    log.info("Accessing: " + no);
                    TimeUnit.SECONDS.sleep(2);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //释放许可
                    semaphore.release();
                }
            });
        }
        //退出线程池
        exec.shutdown();
    }
}
