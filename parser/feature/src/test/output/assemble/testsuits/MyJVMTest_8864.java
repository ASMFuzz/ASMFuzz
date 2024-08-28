public class MyJVMTest_8864 {

    static String mesg = "yE^.BdJ #\\";

    static boolean printDebug = false;

    String logDebug(String mesg) {
        if (printDebug) {
            System.err.println(Thread.currentThread().getName() + ": " + mesg);
        }
        return mesg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8864().logDebug(mesg);
    }
}
