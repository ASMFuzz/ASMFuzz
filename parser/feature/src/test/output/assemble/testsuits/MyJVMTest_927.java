public class MyJVMTest_927 {

    void ensureProperCallingThread() {
        if (myShouldCheckThreads) {
            if (myInitialThread == null) {
                myInitialThread = Thread.currentThread();
            } else if (myInitialThread != Thread.currentThread()) {
                System.out.println("Not working: " + myInitialThread.getName());
            }
        }
    }

    static Thread myThread = null;

    static Thread myInitialThread = null;

    static boolean myShouldCheckThreads = true;

    void run() {
        long runNumber = 0;
        while (true) {
            if (runNumber > 15000) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            runNumber++;
            ensureProperCallingThread();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_927().run();
    }
}
