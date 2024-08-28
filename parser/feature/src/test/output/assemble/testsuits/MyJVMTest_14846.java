public class MyJVMTest_14846 {

    static Thread myThread = null;

    static Thread myInitialThread = null;

    static boolean myShouldCheckThreads = false;

    void ensureProperCallingThread() {
        if (myShouldCheckThreads) {
            if (myInitialThread == null) {
                myInitialThread = Thread.currentThread();
            } else if (myInitialThread != Thread.currentThread()) {
                System.out.println("Not working: " + myInitialThread.getName());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14846().ensureProperCallingThread();
    }
}
