import java.util.Objects;

public class MyJVMTest_12454 {

    static Object lhs = 2;

    static Object rhs = 0;

    static String msg = "}mQT)&(aoU";

    void fail(String message) {
        throw new RuntimeException(message);
    }

    String assertSame(Object lhs, Object rhs, String msg) {
        if (lhs != rhs) {
            msg = Objects.toString(msg, "assertSame") + ": expected " + Objects.toString(lhs) + " to equal " + Objects.toString(rhs);
            fail(msg);
        }
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12454().assertSame(lhs, rhs, msg);
    }
}
