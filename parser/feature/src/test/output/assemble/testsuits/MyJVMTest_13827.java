import java.util.Objects;

public class MyJVMTest_13827 {

    static Object lhs = 7;

    static Object rhs = 0;

    static String msg = "5zD$H@~YZJ";

    void fail(String message) {
        throw new RuntimeException(message);
    }

    Object assertNotEquals(Object lhs, Object rhs, String msg) {
        if ((lhs == rhs) || (lhs != null && lhs.equals(rhs))) {
            msg = Objects.toString(msg, "assertNotEquals") + ": expected " + Objects.toString(lhs) + " to not equal " + Objects.toString(rhs);
            fail(msg);
        }
        return lhs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13827().assertNotEquals(lhs, rhs, msg);
    }
}
