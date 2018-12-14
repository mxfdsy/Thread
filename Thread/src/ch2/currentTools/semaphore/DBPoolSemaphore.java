package ch2.currentTools.semaphore;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * ���ܣ��Թ̶� ��Դ�ķ��ʴ���
 */
public class DBPoolSemaphore {
    private final static int POOL_SIZE = 10;

    //useful ��־���õ����� useless ��ʾ���õ�����
    private final Semaphore useful, useless;

    public DBPoolSemaphore() {
        this.useful = new Semaphore(POOL_SIZE);
        this.useless = new Semaphore(0);
    }

    //������ݿ����������
    private static LinkedList<Connection> pool = new LinkedList<>();

    //��ʼ����
    static {
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.addLast(SqlConnectImpl.fetchConnection());
        }
    }

    //�ӳ���������
    public  Connection takeConnect() throws InterruptedException {
        //useful ����
        useful.acquire();
        Connection conn;
        synchronized (pool) {
            conn = pool.removeFirst();
        }
        //useless ����
        useless.release();
        return conn;
    }

    public void returnConnect(Connection connection) throws InterruptedException {
        if (connection != null) {
            System.out.println("��ǰ��"+useful.getQueueLength()+"���̵߳ȴ����ݿ����ӣ���"
                    +"����������:"+useful.availablePermits());
            //useless�л�ȡ ����
            useless.acquire();
            synchronized (pool) {
                pool.addLast(connection);
            }
            //useful �й黹 ����
            useful.release();
        }
    }
}
