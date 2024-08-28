public class MyJVMTest_12333 {

    static String msg = "2{Kk<9D5%6";

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
        new MyJVMTest_12333().errorHandling(msg);
    }
}
