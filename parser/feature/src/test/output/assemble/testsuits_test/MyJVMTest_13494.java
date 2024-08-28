public class MyJVMTest_13494 {

    static int sleepMillis = 1742597948;

    static boolean keepRunning = true;

    void shutDown() {
        keepRunning = false;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13494().shutDown();
    }
}
