public class MyJVMTest_12671 {

    static boolean cond = false;

    static String msg = "b:,!1~'G9j";

    boolean assertTrue(boolean cond, String msg) {
        if (!cond)
            throw new AssertionError(msg);
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12671().assertTrue(cond, msg);
    }
}
