public class MyJVMTest_5816 {

    static boolean threadStarted = false;

    static Object lock = new Object();

    static String LITERAL = "@@LockDuringDump@@LITERAL";

    void run() {
        try {
            synchronized (LITERAL) {
                System.out.println("Let's hold the lock on the literal string \"" + LITERAL + "\" +  forever .....");
                synchronized (lock) {
                    threadStarted = true;
                    lock.notifyAll();
                }
                while (true) {
                    Thread.sleep(1);
                }
            }
        } catch (Throwable t) {
            System.err.println("Unexpected: " + t);
            throw new RuntimeException(t);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5816().run();
    }
}
