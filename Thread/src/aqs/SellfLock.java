package aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 实现一个自己的 ReentrantLock
 */
public class SellfLock implements Lock {

    private static class Sync extends AbstractQueuedLongSynchronizer {

        //state 表示获取到锁 state=1 获取到了锁，state=0，表示这个锁当前没有线程拿到
        //是否占用
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(long arg) {
            //保证原子性
            if (compareAndSetState(0,1)) {
                //设置当前线程拥有访问权
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(long arg) {
            //放锁时肯定是只有一个线程
            if (getState() == 0) {
                //放锁时state 肯定是1
                throw new UnsupportedOperationException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }


    private final Sync sycn = new Sync();


    @Override
    public void lock() {
        //独占式获取,至少成功一次
        sycn.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        //获取独占模式，如果中断则中止。
        sycn.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        //获取锁
        return sycn.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        //尝试以独占模式获取，如果中断则中止，
        //*如果给定超时超时，则失败。由第一个实现
        //*检查中断状态，然后至少调用一次{@
        return sycn.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sycn.release(1);
    }

    @Override
    public Condition newCondition() {
        return sycn.newCondition();
    }
}
