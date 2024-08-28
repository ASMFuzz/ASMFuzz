public class MyJVMTest_5419 {

    static Thread myThread = null;

    static Thread myInitialThread = null;

    static boolean myShouldCheckThreads = true;

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
        new MyJVMTest_5419().ensureProperCallingThread();
    }
}
