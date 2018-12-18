package Atomic.answer;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class HomeWork {
    static AtomicInteger ai = new AtomicInteger(10);

    static AtomicStampedReference<AtomicInteger> asr = new AtomicStampedReference<>(ai , 0);

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            int stamp = asr.getStamp();
            AtomicInteger reference = asr.getReference();

            ai.incrementAndGet();
            AtomicInteger reference1 = asr.getReference();

            boolean b = asr.compareAndSet(reference, reference1, asr.getStamp(), stamp + 1);
            System.out.println(b);
            System.out.println(ai.get());
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    int stamp = asr.getStamp();
                    AtomicInteger reference = asr.getReference();

                    ai.incrementAndGet();
                    AtomicInteger reference1 = asr.getReference();

                    System.out.println(asr.compareAndSet(reference, reference1, asr.getStamp(), stamp + 1));

                    System.out.println(ai.get());
                }
            }
        });
        thread.start();

    }


}
