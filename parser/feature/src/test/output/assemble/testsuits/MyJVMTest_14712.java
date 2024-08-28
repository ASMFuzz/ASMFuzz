public class MyJVMTest_14712 {

    static long busyTime = 9223372036854775807L;

    void run() {
        long startTime = System.nanoTime();
        while ((System.nanoTime() - startTime) < busyTime) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14712().run();
    }
}
