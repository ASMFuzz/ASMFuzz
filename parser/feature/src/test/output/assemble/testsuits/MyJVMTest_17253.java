public class MyJVMTest_17253 {

    static String mesg = "_$Q5zX{;cG";

    static boolean printDebug = false;

    String logDebug(String mesg) {
        if (printDebug) {
            System.err.println(Thread.currentThread().getName() + ": " + mesg);
        }
        return mesg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17253().logDebug(mesg);
    }
}
