package Atomic.answer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *类说明：有一个残缺AtomicInteger的类实现了线程安全的：
 *get方法和compareAndSet()方法
 *自行实现它的递增方法
 */
public class HalfAtomicInt {
    private AtomicInteger atomicI = new AtomicInteger(0);

    public void increament() {
        for (;;) {
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            System.out.println(atomicI.get());
            if (suc) {
                break;
            }
        }
    }

    static class TestThread extends Thread {
        @Override
        public void run() {
            HalfAtomicInt halfAtomicInt = new HalfAtomicInt();
            halfAtomicInt.increament();
        }
    }

    
    public int getCount() {
    	return atomicI.get();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            TestThread testThread = new TestThread();
            testThread.start();
            testThread.join();
        }
        HalfAtomicInt halfAtomicInt = new HalfAtomicInt();
        System.out.println("最后输出");
        halfAtomicInt.increament();

    }

}
