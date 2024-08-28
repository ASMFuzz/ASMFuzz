public class MyJVMTest_10240 {

    static boolean done = false;

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 2;

    static Object noti = 5;

    void run() {
        started = true;
        while (!done) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10240().run();
    }
}
