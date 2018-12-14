package ch2.currentTools.semaphore;

import baseThread.tools.SleepTools;

import java.sql.Connection;
import java.util.Random;

/**
 * 测试 数据库连接池
 */
public class AppTest {
    private static DBPoolSemaphore dbpol = new DBPoolSemaphore();


    //获取数据库连接的业务线程
    private static class BusinessThread extends Thread {
        @Override
        public void run() {
            Random r = new Random();
            long start = System.currentTimeMillis();

            try {
                Connection connection = dbpol.takeConnect();
                System.out.println("Thread_"+Thread.currentThread().getId()
                        +"_获取数据库连接共耗时【"+(System.currentTimeMillis()-start)+"】ms.");

                //模拟业务操作，线程持有连接查询数据
                SleepTools.ms(100+r.nextInt(100));
                System.out.println("查询数据完成，归还连接！");
                dbpol.returnConnect(connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            Thread thread = new BusinessThread();
            thread.start();
        }
    }

}

