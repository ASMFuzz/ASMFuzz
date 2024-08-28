import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_2503 {

    static int Init1Tick = 511938051;

    void shouldNotCallThis() {
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2503().shouldNotCallThis();
    }
}
