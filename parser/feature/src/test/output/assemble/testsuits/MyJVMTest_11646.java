public class MyJVMTest_11646 {

    static String tParam1Param1 = "NTZJioXlO(";

    static ThreadGroup tParam1 = new ThreadGroup(tParam1Param1);

    static Runnable tParam2 = () -> {
    };

    static String tParam3 = "z\"iJMaZw@7";

    static Thread t = new Thread(tParam1, tParam2, tParam3);

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
        System.out.println(new MyJVMTest_11646().waitForThreadStop(t));
    }
}
