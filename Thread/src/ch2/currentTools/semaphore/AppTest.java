package ch2.currentTools.semaphore;

import baseThread.tools.SleepTools;

import java.sql.Connection;
import java.util.Random;

/**
 * ���� ���ݿ����ӳ�
 */
public class AppTest {
    private static DBPoolSemaphore dbpol = new DBPoolSemaphore();


    //��ȡ���ݿ����ӵ�ҵ���߳�
    private static class BusinessThread extends Thread {
        @Override
        public void run() {
            Random r = new Random();
            long start = System.currentTimeMillis();

            try {
                Connection connection = dbpol.takeConnect();
                System.out.println("Thread_"+Thread.currentThread().getId()
                        +"_��ȡ���ݿ����ӹ���ʱ��"+(System.currentTimeMillis()-start)+"��ms.");

                //ģ��ҵ��������̳߳������Ӳ�ѯ����
                SleepTools.ms(100+r.nextInt(100));
                System.out.println("��ѯ������ɣ��黹���ӣ�");
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

