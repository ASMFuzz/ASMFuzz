public class MyJVMTest_4788 {

    static boolean err = true;

    static String msg = "#z3{DQ_9>G";

    boolean check(boolean err, String msg) {
        if (err) {
            throw new RuntimeException("Error: " + msg);
        }
        return err;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4788().check(err, msg);
    }
}
