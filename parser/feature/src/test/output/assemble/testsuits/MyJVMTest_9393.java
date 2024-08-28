import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_9393 {

    void run() {
        try {
            MethodHandle m1 = MethodHandles.lookup().findStatic(Test7082949.class, "test", methodType(Test7082949.class));
            Test7082949 v = (Test7082949) m1.invokeExact();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9393().run();
    }
}
