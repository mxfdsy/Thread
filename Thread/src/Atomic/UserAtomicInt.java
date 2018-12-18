package Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * int 的原子性
 */
public class UserAtomicInt {
    static AtomicInteger ai = new AtomicInteger(10);

    public static void main(String[] args) {
        //获取为增加之前的
        System.out.println(ai.getAndIncrement());
        //获取增加之后的
        System.out.println(ai.incrementAndGet());
        //获取原来的数据
        System.out.println(ai.get());
    }
}
