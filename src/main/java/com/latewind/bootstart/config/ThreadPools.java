package com.latewind.bootstart.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class ThreadPools {


    static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "fix-thread");
        }
    });


    public static ScheduledExecutorService getExecutorService() {
        return executorService;
    }

    public static void shutdown() {
        executorService.shutdownNow();
    }
}
