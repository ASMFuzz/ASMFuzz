import java.lang.invoke.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_15229 {

    static Object o1 = 0;

    static Object o2 = 1843319406;

    Object assertEquals(Object o1, Object o2) {
        if (!o1.equals(o2)) {
            throw new RuntimeException(o1 + " != " + o2);
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15229().assertEquals(o1, o2);
    }
}
