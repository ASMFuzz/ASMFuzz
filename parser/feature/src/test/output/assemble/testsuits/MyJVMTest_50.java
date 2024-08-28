public class MyJVMTest_50 {

    static boolean notified = false;

    void waitForNotification() throws InterruptedException {
        while (!notified) wait();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_50().waitForNotification();
    }
}
