package ch2.usefuture;



import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UseFuture {
    private static class UseCallable implements Callable<Integer> {

        private int sum;

        @Override
        public Integer call() throws Exception {
            System.out.println("Callable子线程开始计算");
            Thread.sleep(2000);
            for (int i = 0; i <= 5000; i++) {
                sum = sum + i;

            }
            System.out.println("Callable子线程计算结果 sum = "+ sum);
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        UseCallable useCallable = new UseCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(useCallable);
        new java.lang.Thread(futureTask).start();
        Random random = new Random();
        if (random.nextBoolean()) {
            System.out.println("get usecallable result = " + futureTask.get());
        } else {
            System.out.println("interrupted");
            futureTask.cancel(true);
        }
    }
}
