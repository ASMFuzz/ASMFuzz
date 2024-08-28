public class MyJVMTest_7055 {

    static Thread theThread = null;

    void run() {
        synchronized (theThread) {
            theThread.notify();
        }
        theThread.start();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7055().run();
    }
}
