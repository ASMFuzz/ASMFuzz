public class MyJVMTest_3027 {

    static String msg = "$*k.U!|~kW";

    static boolean error = false;

    static boolean abort = false;

    static char R = '\u202F';

    String errorHandling(String msg) {
        if (abort) {
            throw new RuntimeException("Error: " + msg);
        } else {
            error = true;
            System.err.println("**Error:" + msg);
        }
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3027().errorHandling(msg);
    }
}
