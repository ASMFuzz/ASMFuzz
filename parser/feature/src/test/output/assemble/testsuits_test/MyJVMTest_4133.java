public class MyJVMTest_4133 {

    static int sleepMillis = 0;

    static boolean keepRunning = true;

    void shutDown() {
        keepRunning = false;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4133().shutDown();
    }
}
