package baseThread.safeend;

/**
 * ��ΰ�ȫ���ж��߳�
 */
public class EndThread {

    private static class UseThread extends Thread {

        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()) {
                System.out.println(threadName + " is run");
                Thread.currentThread().interrupt();
            }
            System.out.println(threadName+" interrput flag is "+isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread cww = new UseThread("cww");
        cww.start();
        Thread.sleep(200);
        cww.interrupt();
    }


}
