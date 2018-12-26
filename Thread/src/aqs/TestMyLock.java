package aqs;

import baseThread.tools.SleepTools;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMyLock {
    final Lock lock = new SellfLock();

    public void test() {

        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepTools.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepTools.second(1);
                    }finally {
                        lock.unlock();
                    }
                    SleepTools.second(2);
                }
            }
        }

        // 启动10个子线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            //设置为守护线程
            w.setDaemon(true);
            w.start();
        }

        // 主线程每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepTools.second(1);
            System.out.println("swap");
            System.out.println();
        }

    }

    public static void main(String[] args) {

        TestMyLock testMyLock = new TestMyLock();
        testMyLock.test();


    }
}
