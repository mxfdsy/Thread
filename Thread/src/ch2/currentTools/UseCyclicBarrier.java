package ch2.currentTools;

import java.util.Map;
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

        }
    }




    //负责屏障开放以后的工作
    private static class CollectThread implements Runnable {
        @Override
        public void run() {
            StringBuilder result = new StringBuilder();
            for (Map.Entry<String, Long> workResult : resultMap.entrySet()) {
                result.append("["+workResult.getValue()+"]");
            }
            System.out.println(" the result = "+ result);
            System.out.println("do other business........");
        }
    }

}
