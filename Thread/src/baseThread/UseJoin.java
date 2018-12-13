package baseThread;

import baseThread.tools.SleepTools;

public class UseJoin {
    static class JumpQueue implements Runnable {
        //用来插队的线程
        private Thread thread;

        public JumpQueue(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            System.out.println(thread.getName() + "i will cha");
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(thread.getName() + " terminted");
        }
    }

    public static void main(String[] args) {
        Thread previous = Thread.currentThread();//现在是主线程
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new JumpQueue(previous), String.valueOf(i));
            System.out.println(previous.getName() + "i alreal cha");

            thread.start();
            previous = thread;
        }

        SleepTools.second(5);
        System.out.println(Thread.currentThread().getName() + "terminate");
    }

}
