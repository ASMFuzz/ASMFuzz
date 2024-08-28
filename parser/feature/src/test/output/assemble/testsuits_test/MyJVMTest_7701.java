public class MyJVMTest_7701 {

    static String mesg = "fn'XpsvX>/";

    static boolean printDebug = false;

    String logDebug(String mesg) {
        if (printDebug) {
            System.err.println(Thread.currentThread().getName() + ": " + mesg);
        }
        return mesg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7701().logDebug(mesg);
    }
}
