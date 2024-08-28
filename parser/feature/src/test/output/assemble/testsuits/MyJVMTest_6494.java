public class MyJVMTest_6494 {

    static long delay = 9223372036854775807L;

    long pause(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException exception) {
        }
        return delay;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6494().pause(delay);
    }
}
