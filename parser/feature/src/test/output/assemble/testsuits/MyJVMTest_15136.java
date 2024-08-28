public class MyJVMTest_15136 {

    static boolean value = true;

    static String msg = "p,/Ha&GL@[";

    void error(String msg) {
        throw new RuntimeException(msg);
    }

    boolean assertTrue(boolean value, String msg) {
        if (!value) {
            error(msg);
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15136().assertTrue(value, msg);
    }
}
