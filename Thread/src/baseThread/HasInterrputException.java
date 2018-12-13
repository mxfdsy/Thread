package baseThread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HasInterrputException {
//    private static SimpleDateFormat formater
//            = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_SSS");

    private static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()) {
//                System.out.println("UseThread:"+formater.format(new Date()));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
//                    System.out.println(threadName+" catch interrput flag is "
//                            +isInterrupted()+ " at "
//                            +(formater.format(new Date())));
                    interrupt();
                    e.printStackTrace();

                }
                System.out.println(threadName+ "出了异常我还是在跑");
            }
            System.out.println(threadName+" interrput flag is "
                    +isInterrupted());
        }

        public static void main(String[] args) throws InterruptedException {
            Thread endThread = new UseThread("HasInterrputEx");
            endThread.start();
//            System.out.println("Main:"+formater.format(new Date()));
            Thread.sleep(800);
//            System.out.println("Main begin interrupt thread:"+formater.format(new Date()));
            endThread.interrupt();
        }
    }

}
