public class MyJVMTest_13854 {

    static long millis = 6113116536994070565L;

    static long start = 625396004191133048L;

    static long time = 0;

    long pause(long millis) throws InterruptedException {
        Thread.sleep(millis);
        return millis;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13854().pause(millis);
    }
}
