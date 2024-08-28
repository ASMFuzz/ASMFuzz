import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_16820 {

    static Object expect = -1659939759;

    static Object observe = 7;

    Object assertEquals(Object expect, Object observe) {
        if (java.util.Objects.equals(expect, observe))
            return;
        String msg = ("expected " + expect + " but observed " + observe);
        System.out.println("FAILED: " + msg);
        throw new AssertionError(msg);
        return observe;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16820().assertEquals(expect, observe);
    }
}
