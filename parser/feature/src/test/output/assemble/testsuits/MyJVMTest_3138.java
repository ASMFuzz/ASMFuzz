import java.util.Objects;

public class MyJVMTest_3138 {

    static Object lhs = 0;

    static Object rhs = -783021557;

    static String msg = "]wTQnF5GL[";

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
        new MyJVMTest_3138().assertSame(lhs, rhs, msg);
    }
}
