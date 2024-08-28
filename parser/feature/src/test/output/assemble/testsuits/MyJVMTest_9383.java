public class MyJVMTest_9383 {

    static String tParam1Param1 = "mwg2j@99O2";

    static ThreadGroup tParam1 = new ThreadGroup(tParam1Param1);

    static Runnable tParam2 = () -> {
    };

    static Thread t = new Thread(tParam1, tParam2);

    static Object runForestRun = new Object();

    static boolean forestIsRunning = false;

    boolean waitForThreadStart(Thread t) {
        t.start();
        while (!forestIsRunning) {
            try {
                runForestRun.wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9383().waitForThreadStart(t));
    }
}
