import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_13882 {

    static int Init1Tick = 3;

    static int Init3Tick = 0;

    int baz() {
        return Init3Tick;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13882().baz());
    }
}
