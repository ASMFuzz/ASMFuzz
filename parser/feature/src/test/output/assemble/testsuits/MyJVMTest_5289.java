public class MyJVMTest_5289 {

    static long busyTime = 2149597151154754122L;

    void run() {
        long startTime = System.nanoTime();
        while ((System.nanoTime() - startTime) < busyTime) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5289().run();
    }
}
