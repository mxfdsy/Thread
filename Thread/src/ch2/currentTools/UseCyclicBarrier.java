package ch2.currentTools;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class UseCyclicBarrier {
    private static CyclicBarrier barrier = new CyclicBarrier(5, new CollectThread());

    //������̹߳������������
    private static ConcurrentHashMap<String, Long> resultMap = new ConcurrentHashMap<>();


    //�����߳�
    private static class SubThread implements Runnable {
        @Override
        public void run() {

        }
    }




    //�������Ͽ����Ժ�Ĺ���
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
