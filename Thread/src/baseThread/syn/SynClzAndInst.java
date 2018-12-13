package baseThread.syn;

import baseThread.tools.SleepTools;

/**
 * ��ʾ������������
 */
public class SynClzAndInst {

    //ʹ���������߳�
    private static class SynClass extends Thread{
        @Override
        public void run() {
            System.out.println("TestClass is running...");
            synClass();
        }
    }

    //ʹ�ö��������߳�
    private static class InstanceSyn implements Runnable{
        private SynClzAndInst synClzAndInst;

        public InstanceSyn(SynClzAndInst synClzAndInst) {
            this.synClzAndInst = synClzAndInst;
        }

        public InstanceSyn() {

        }

        @Override
        public void run() {
            System.out.println("TestInstance is running..."+synClzAndInst);
            synClzAndInst.instance();
        }
    }

    //ʹ�ö��������߳�
    private static class Instance2Syn implements Runnable{
        private SynClzAndInst synClzAndInst;

        public Instance2Syn(SynClzAndInst synClzAndInst) {
            this.synClzAndInst = synClzAndInst;
        }
        @Override
        public void run() {
            System.out.println("TestInstance2 is running..."+synClzAndInst);
//            synClzAndInst.instance2();
        }
    }


    //������ʵ���������class����
    private static synchronized void synClass(){
        SleepTools.second(1);
        System.out.println("synClass going...");
        SleepTools.second(1);
        System.out.println("synClass end");
    }


    //������
    private synchronized void instance(){
        SleepTools.second(3);
        System.out.println("synInstance is going..."+this.toString());
        SleepTools.second(3);
        System.out.println("synInstance ended "+this.toString());
    }

    public static void main(String[] args) {
        //��ʾ���������ֽ����ļ�
//        SynClass synClass = new SynClass();
//        SynClass synClass1 = new SynClass();
//        synClass.start();
//        synClass1.start();

        //��ʾ������������
        SynClzAndInst synClzAndInst = new SynClzAndInst();
        Thread thread = new Thread(new InstanceSyn(synClzAndInst));

//        SynClzAndInst synClzAndInst2 = new SynClzAndInst();
        Thread thread2 = new Thread(new InstanceSyn(synClzAndInst));

        thread.start();
        thread2.start();
    }

}
