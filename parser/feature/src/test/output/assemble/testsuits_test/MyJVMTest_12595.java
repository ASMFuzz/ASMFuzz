import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_12595 {

    static int Init1Tick = 7;

    int foo() {
        return Init1Tick;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12595().foo());
    }
}
