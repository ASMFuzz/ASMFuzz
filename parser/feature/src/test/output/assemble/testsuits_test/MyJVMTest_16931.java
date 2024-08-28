import java.util.Objects;

public class MyJVMTest_16931 {

    static Object lhs = 0;

    static Object rhs = 3;

    static String msg = "ztuO@Lfet&";

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
        new MyJVMTest_16931().assertEquals(lhs, rhs, msg);
    }
}
