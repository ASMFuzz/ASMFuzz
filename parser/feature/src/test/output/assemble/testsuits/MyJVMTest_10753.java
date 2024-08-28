public class MyJVMTest_10753 {

    static boolean threadStarted = false;

    static Object lock = new Object();

    void waitForThreadStart() {
        try {
            synchronized (lock) {
                while (!threadStarted) {
                    lock.wait();
                }
                System.out.println("Thread has started");
            }
        } catch (Throwable t) {
            System.err.println("Unexpected: " + t);
            throw new RuntimeException(t);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10753().waitForThreadStart();
    }
}
