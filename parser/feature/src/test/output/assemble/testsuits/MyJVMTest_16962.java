public class MyJVMTest_16962 {

    static String msg = "cllCN}Nb7X";

    static boolean verbose = true;

    String log(String msg) {
        if (verbose) {
            System.out.println(msg);
        }
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16962().log(msg);
    }
}
