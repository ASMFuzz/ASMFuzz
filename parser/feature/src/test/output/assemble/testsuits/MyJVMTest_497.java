public class MyJVMTest_497 {

    static long startTime = 0;

    static long endTime = 0;

    void run() {
        long t = System.nanoTime();
        if (startTime == 0)
            startTime = t;
        else
            endTime = t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_497().run();
    }
}
