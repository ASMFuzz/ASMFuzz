import java.lang.invoke.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_5785 {

    static Object o1 = 1246789279;

    static Object o2 = 0;

    Object assertEquals(Object o1, Object o2) {
        if (!o1.equals(o2)) {
            throw new RuntimeException(o1 + " != " + o2);
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5785().assertEquals(o1, o2);
    }
}
