package ch2.currentTools;

import baseThread.tools.SleepTools;

import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch {
    //创建6个扣除点
    static CountDownLatch latch = new CountDownLatch(6);

    //初始化线程
    private static class InitThred implements Runnable {
        @Override
        public void run() {
            System.out.println("初始化线程开始工作，即将初始化完成，准备扣除");
            //初始化完成，扣除一次
            latch.countDown();
            for (int i = 0; i < 2; i++) {
                System.out.println("扣除完成我也可以继续工作");
            }
        }
    }

    //业务线程
    private static class BusinessThred implements Runnable {
        @Override
        public void run() {
            //还没扣除玩让它等着
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("业务线程的业务，就是做业务");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //在main 方法里面在设置一个线程，进行扣减，扣减两次
        new Thread(new Runnable() {
            @Override
            public void run() {
                SleepTools.ms(1);
                System.out.println("mian 方法里的新建线程t 准备完成初始化");
                //初始化完成开始第一次扣减
                latch.countDown();
                System.out.println("第二步骤开始初始化花");
                //第二次扣减
                latch.countDown();
            }
        }).start();

        new Thread(new BusinessThred()).start();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new InitThred());
            thread.start();
        }
        latch.countDown();
        latch.await();
        System.out.println("main do its work");
    }

}

