public class MyJVMTest_1048 {

    static boolean done = false;

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 4;

    static Object noti = 0;

    void run() {
        started = true;
        while (!done) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1048().run();
    }
}
