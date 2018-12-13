package baseThread.DBPool;

import java.sql.Connection;
import java.util.LinkedList;

public class DBPool {
    //数据库容器
    private static LinkedList<Connection>  pool = new LinkedList<>();

    //初始化连接数
     public DBPool(int initalSize) {
         if (initalSize > 0) {
             for (int i = 0; i < initalSize; i++) {
                 pool.addLast(SqlConnectImpl.fetchConnection());
             }
         }

     }

    //在Mills时间内还拿不到数据库连接，返回一个Null
    public Connection fetchConn(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills < 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long overtime = System.currentTimeMillis() + mills;
                long remian = mills;
                while (pool.isEmpty() && remian > 0) {
                    pool.wait(remian);
                    remian = overtime - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }

    //释放数据库连接
    public void releaseConn(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

}
