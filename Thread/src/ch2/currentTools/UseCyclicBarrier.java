package ch2.currentTools;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class UseCyclicBarrier {
    private static CyclicBarrier barrier = new CyclicBarrier(5, new CollectThread());

    //存放子线程工作结果的容器
    private static ConcurrentHashMap<String, Long> resultMap = new ConcurrentHashMap<>();


    //工作线程
    private static class SubThread implements Runnable {
        @Override
        public void run() {
            long id = Thread.currentThread().getId();
            resultMap.put(Thread.currentThread().getId() + "", id);
            Random r = new Random();
            try {
                if (r.nextBoolean()) {
                    Thread.sleep(2000 + id);
                    System.out.println(id + "is do something");
                }
                System.out.println(id + "is wait");
                barrier.await();
                Thread.sleep(1000 + id);
                System.out.println(id + "do its business");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //负责屏障开放以后的工作
    private static class CollectThread implements Runnable {
        @Override
        public void run() {
            StringBuilder result = new StringBuilder();
            for (Map.Entry<String, Long> workResult : resultMap.entrySet()) {
                result.append("[" + workResult.getValue() + "]");
            }
            System.out.println(" the result = " + result);
            System.out.println("do other business........");
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SubThread());
            thread.start();
        }
    }


}
