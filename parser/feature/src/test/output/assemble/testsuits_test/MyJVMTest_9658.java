public class MyJVMTest_9658 {

    static long startTime = 0;

    static long endTime = -1661339029914492463L;

    void run() {
        long t = System.nanoTime();
        if (startTime == 0)
            startTime = t;
        else
            endTime = t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9658().run();
    }
}
