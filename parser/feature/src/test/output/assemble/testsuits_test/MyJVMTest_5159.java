public class MyJVMTest_5159 {

    static String message = "2|r nMD(I}";

    static boolean b = false;

    void fail(String message) {
        throw new RuntimeException(message);
    }

    static String text = "'mn7v-0(F%";

    String assertTrue(String message, boolean b) {
        if (!b)
            fail(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5159().assertTrue(message, b);
    }
}
