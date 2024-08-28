public class MyJVMTest_15982 {

    static long delay = -9223372036854775808L;

    long pause(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException exception) {
        }
        return delay;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15982().pause(delay);
    }
}
