package ch2.currentTools.semaphore;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * 功能：对固定 资源的访问次数
 */
public class DBPoolSemaphore {
    private final static int POOL_SIZE = 10;

    //useful 标志可用的连接 useless 表示已用的连接
    private final Semaphore useful, useless;

    public DBPoolSemaphore() {
        this.useful = new Semaphore(POOL_SIZE);
        this.useless = new Semaphore(0);
    }

    //存放数据库的连接容器
    private static LinkedList<Connection> pool = new LinkedList<>();

    //初始化池
    static {
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.addLast(SqlConnectImpl.fetchConnection());
        }
    }

    //从池子拿连接
    public  Connection takeConnect() throws InterruptedException {
        //useful 减少
        useful.acquire();
        Connection conn;
        synchronized (pool) {
            conn = pool.removeFirst();
        }
        //useless 增加
        useless.release();
        return conn;
    }

    public void returnConnect(Connection connection) throws InterruptedException {
        if (connection != null) {
            System.out.println("当前有"+useful.getQueueLength()+"个线程等待数据库连接！！"
                    +"可用连接数:"+useful.availablePermits());
            //useless中获取 减少
            useless.acquire();
            synchronized (pool) {
                pool.addLast(connection);
            }
            //useful 中归还 增加
            useful.release();
        }
    }
}
