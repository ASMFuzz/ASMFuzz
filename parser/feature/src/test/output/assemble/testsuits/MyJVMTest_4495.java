import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_4495 {

    static int Init1Tick = 0;

    static int Init3Tick = 8;

    int baz() {
        return Init3Tick;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4495().baz());
    }
}
