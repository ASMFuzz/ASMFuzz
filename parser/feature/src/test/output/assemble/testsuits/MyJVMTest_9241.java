public class MyJVMTest_9241 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 8;

    static Object noti = 3;

    void run() {
        started = true;
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9241().run();
    }
}
