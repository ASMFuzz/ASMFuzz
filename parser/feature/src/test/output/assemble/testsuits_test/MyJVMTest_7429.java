public class MyJVMTest_7429 {

    static String msg = "^%dJIV#&TR";

    static boolean verbose = false;

    String log(String msg) {
        if (verbose) {
            System.out.println(msg);
        }
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7429().log(msg);
    }
}
