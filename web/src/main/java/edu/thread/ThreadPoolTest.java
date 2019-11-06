package edu.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的使用
 */
public class ThreadPoolTest implements Runnable {

    public void run() {
        try {
            Thread.sleep(10);
            System.out.println("======run===");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName());
    }

    /**
     * 阿里规范不建议使用Executors工厂类创建线程池
     * 原因是无法直接接触ThreadPoolExecutor参数，且newFixedThreadPool不限制最大任务数量，newCachedThreadPool不限制最大线程数，
     * 不规范使用将消耗大量CPU，导致OOM异常
     */
    static ExecutorService executorService = Executors.newFixedThreadPool(3);
    static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        int a = -1<<29;
        System.out.println(a);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ThreadPoolTest());
//            Future<?> submit = executorService.submit(new ThreadPoolTest());
        }
        executorService.shutdown();
//        executorService.shutdownNow();
    }
}
