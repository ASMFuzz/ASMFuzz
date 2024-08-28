public class MyJVMTest_232 {

    static String tParam1Param1Param1Param1 = "5YiV#8o?0K";

    static ThreadGroup tParam1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1);

    static String tParam1Param1Param2 = "b&]Al6:$U'";

    static ThreadGroup tParam1Param1 = new ThreadGroup(tParam1Param1Param1, tParam1Param1Param2);

    static String tParam1Param2 = "Nl+]>I%,El";

    static ThreadGroup tParam1 = new ThreadGroup(tParam1Param1, tParam1Param2);

    static Runnable tParam2 = () -> {
    };

    static String tParam3 = "LW5*J=n1CT";

    static Thread t = new Thread(tParam1, tParam2, tParam3);

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
        System.out.println(new MyJVMTest_232().waitForThreadStart(t));
    }
}
