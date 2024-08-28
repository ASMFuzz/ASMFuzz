public class MyJVMTest_4469 {

    static long millis = 0;

    static long start = -1738065380224846573L;

    static long time = -9223372036854775808L;

    long pause(long millis) throws InterruptedException {
        Thread.sleep(millis);
        return millis;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4469().pause(millis);
    }
}
