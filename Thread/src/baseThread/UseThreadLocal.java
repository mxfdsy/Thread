package baseThread;

/**
 * 演示 ThreadLocal
 */
public class UseThreadLocal {

    /**
     * 简单的理解为 一个map 类型Map<Thread,Integer> 读写的值 不影响但是这样的话 就是占资源了
     */
    static  ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    /**
     * 运行三个线程
     */
    public void StartThreadArray() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
        runs[i]= new Thread(new TestThread(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    /**
     * 测试 threadLocal
     */
    public static class TestThread implements Runnable {
        int id;

        public TestThread(int id){
            this.id = id;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+ "start");
            Integer s = threadLocal.get();
            s = s + id;
            threadLocal.set(s);
            System.out.println(Thread.currentThread().getName()+ ":" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        UseThreadLocal test = new UseThreadLocal();
        test.StartThreadArray();

    }
}
