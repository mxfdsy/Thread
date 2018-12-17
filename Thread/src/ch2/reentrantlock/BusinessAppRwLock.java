package ch2.reentrantlock;

import baseThread.tools.SleepTools;

import java.util.Random;

public class BusinessAppRwLock {

    static final int readWriteRatio = 10;//读写线程的比例
    static final int minthreadCount = 3;//最少线程数

    //读操作
    private static class GetTread implements Runnable {

        private GoodsService goodsService;

        public  GetTread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                goodsService.getNum();
            }
            System.out.println(Thread.currentThread().getName()+"读取商品数据耗时："
                    +(System.currentTimeMillis()-start)+"ms");
        }
    }




    //写操作
    private static class SetThread implements Runnable{

        private GoodsService goodsService;

        public  SetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @Override
        public void run() {

            long start = System.currentTimeMillis();
            Random r = new Random();
            for (int i = 0; i < 10; i++) {
                SleepTools.ms(50);
                goodsService.setNum(r.nextInt(10));
            }

            System.out.println(Thread.currentThread().getName()
                    +"写商品数据耗时："+(System.currentTimeMillis()-start)+"ms---------");
        }
    }




    public static void main(String[] args) {
        GoodsInfo goodsInfo = new GoodsInfo("Cup",100000,10000);

        GoodsService goodsService = new UseRwLock(goodsInfo);

        for (int i = 0; i < minthreadCount; i++) {
            Thread setT = new Thread(new SetThread(goodsService));
            for (int j = 0; j < readWriteRatio; j++) {
                Thread getT = new Thread(new GetTread(goodsService));
                getT.start();
            }
            SleepTools.ms(100);
            setT.start();
        }
    }
}
