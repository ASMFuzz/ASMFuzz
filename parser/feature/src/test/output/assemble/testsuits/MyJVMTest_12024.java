import java.util.Objects;

public class MyJVMTest_12024 {

    static boolean value = true;

    static String msg = "Z`siH<[=![";

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
        new MyJVMTest_12024().assertTrue(value, msg);
    }
}
