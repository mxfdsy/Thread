package baseThread.safeend;

/**
 * ��ΰ�ȫ���ж��߳�
 */
public class EndRunnable {
    public static class UseRunnable implements Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            while (Thread.currentThread().isInterrupted()) {
                System.out.println(name + " is run");
            }

            System.out.println(name + "interrput falg is" + Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseRunnable useRunnable = new UseRunnable();
        Thread endThread = new Thread(useRunnable);
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();

    }

}
