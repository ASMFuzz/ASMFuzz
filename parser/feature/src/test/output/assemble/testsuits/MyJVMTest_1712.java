public class MyJVMTest_1712 {

    static CancellableTimer timer = null;

    static String name = "91OD&x@+T ";

    static boolean failed = false;

    static boolean hasBeenNotified = false;

    void run() {
        Thread timerThread = new Thread(timer);
        try {
            synchronized (this) {
                timerThread.start();
                wait();
            }
        } catch (InterruptedException e) {
            System.err.println(name + " was interrupted during wait()");
            failed = true;
        }
        if (!hasBeenNotified) {
            System.err.println(name + ".hasBeenNotified is not true as expected");
            failed = true;
        }
        synchronized (timer) {
            timerThread.interrupt();
        }
        try {
            timerThread.join();
        } catch (InterruptedException ie) {
            System.err.println(name + " was interrupted while joining " + timer.name);
            failed = true;
        }
        if (timerThread.isAlive()) {
            System.err.println(timer.name + " is still alive after " + name + " attempted to join it.");
            failed = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1712().run();
    }
}
