public class MyJVMTest_14186 {

    static boolean err = false;

    static String msg = "1^t+JcooJB";

    boolean check(boolean err, String msg) {
        if (err) {
            throw new RuntimeException("Error: " + msg);
        }
        return err;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14186().check(err, msg);
    }
}
