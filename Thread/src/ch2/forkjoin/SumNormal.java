package ch2.forkjoin;

import baseThread.tools.SleepTools;

public class SumNormal {
    public static void main(String[] args) {
        int[] makeArray = MakeArray.makeArray();
        int count = 0;

        long start = System.currentTimeMillis();
        for (int i = 0; i < makeArray.length; i++) {
            SleepTools.ms(1);
            count = count + 1;
        }
        System.out.println("The count is "+count
                +" spend time:"+(System.currentTimeMillis()-start)+"ms");
    }
}
