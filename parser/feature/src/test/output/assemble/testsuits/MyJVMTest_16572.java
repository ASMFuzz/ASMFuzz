public class MyJVMTest_16572 {

    static Thread theThread = null;

    void run() {
        synchronized (theThread) {
            theThread.notify();
        }
        theThread.start();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16572().run();
    }
}
