public class MyJVMTest_97 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 2;

    static Object noti = 1145882789;

    void run() {
        started = true;
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_97().run();
    }
}
