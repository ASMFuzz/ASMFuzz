import java.util.Objects;

public class MyJVMTest_5250 {

    static boolean value = false;

    static String msg = "Hl;(LyA><2";

    void fail(String message) {
        throw new RuntimeException(message);
    }

    String assertFalse(boolean value, String msg) {
        if (value) {
            msg = Objects.toString(msg, "assertFalse") + ": expected false, was true";
            fail(msg);
        }
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5250().assertFalse(value, msg);
    }
}
