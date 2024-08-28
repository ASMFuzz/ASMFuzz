public class MyJVMTest_5697 {

    static boolean value = false;

    static String msg = "C7;=WQs6QI";

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
        new MyJVMTest_5697().assertTrue(value, msg);
    }
}
