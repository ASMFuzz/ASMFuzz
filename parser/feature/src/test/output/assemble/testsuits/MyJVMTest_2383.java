public class MyJVMTest_2383 {

    static String tParam1Param1Param1Param1Param1Param1Param1 = "u9:X^Dzyka";

    static ThreadGroup tParam1Param1Param1Param1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1Param1Param1Param1);

    static String tParam1Param1Param1Param1Param1Param2 = "3]FFnu7<\\d";

    static ThreadGroup tParam1Param1Param1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1Param1Param1, tParam1Param1Param1Param1Param1Param2);

    static String tParam1Param1Param1Param1Param2 = "F1L{dI2((j";

    static ThreadGroup tParam1Param1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1Param1, tParam1Param1Param1Param1Param2);

    static String tParam1Param1Param1Param2 = "ye:c<5UxS/";

    static ThreadGroup tParam1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1, tParam1Param1Param1Param2);

    static String tParam1Param1Param2 = "c%AhRV>R]V";

    static ThreadGroup tParam1Param1 = new ThreadGroup(tParam1Param1Param1, tParam1Param1Param2);

    static String tParam1Param2 = "7PhC8`SKIQ";

    static ThreadGroup tParam1 = new ThreadGroup(tParam1Param1, tParam1Param2);

    static String tParam2 = "Tn3i[qwMma";

    static Thread t = new Thread(tParam1, tParam2);

    boolean waitForThreadStop(Thread t) {
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2383().waitForThreadStop(t));
    }
}
