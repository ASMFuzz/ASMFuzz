import java.util.Objects;

public class MyJVMTest_2734 {

    static boolean value = false;

    static String msg = "R4h6uC4^`Q";

    void fail(String message) {
        throw new RuntimeException(message);
    }

    String assertTrue(boolean value, String msg) {
        if (!value) {
            msg = Objects.toString(msg, "assertTrue") + ": expected true, was false";
            fail(msg);
        }
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2734().assertTrue(value, msg);
    }
}
