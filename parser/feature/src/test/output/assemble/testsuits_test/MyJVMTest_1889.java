public class MyJVMTest_1889 {

    static boolean thread_started = false;

    static boolean do_monitor_acquire = false;

    static boolean monitor_acquired = false;

    static Object monitor = new Object();

    void run() {
        thread_started = true;
        while (!do_monitor_acquire) ;
        System.out.println("Ok to try to acquire the lock");
        synchronized (monitor) {
            monitor_acquired = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1889().run();
    }
}
