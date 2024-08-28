import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_11774 {

    static int Init1Tick = 8;

    void shouldNotCallThis() {
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11774().shouldNotCallThis();
    }
}
