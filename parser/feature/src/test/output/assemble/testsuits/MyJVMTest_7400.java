import java.util.Objects;

public class MyJVMTest_7400 {

    static Object lhs = 1891516395;

    static Object rhs = 5;

    static String msg = "`M9 z&F,e*";

    void fail(String message) {
        throw new RuntimeException(message);
    }

    Object assertEquals(Object lhs, Object rhs, String msg) {
        if ((lhs != rhs) && ((lhs == null) || !(lhs.equals(rhs)))) {
            msg = Objects.toString(msg, "assertEquals") + ": expected " + Objects.toString(lhs) + " to equal " + Objects.toString(rhs);
            fail(msg);
        }
        return lhs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7400().assertEquals(lhs, rhs, msg);
    }
}
