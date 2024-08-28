import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_3273 {

    static int Init1Tick = -1425251792;

    int foo() {
        return Init1Tick;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3273().foo());
    }
}
