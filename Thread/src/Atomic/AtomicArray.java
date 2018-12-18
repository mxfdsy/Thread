package Atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子数组
 */
public class AtomicArray {
    static int[] value = new int[]{1,2};

    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        System.out.println(ai.getAndSet(0, 3));
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }



}
