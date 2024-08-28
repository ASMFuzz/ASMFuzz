import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_12271 {

    static int Init1Tick = 740487913;

    static int Init2Tick = 5;

    int bar() {
        return Init2Tick;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12271().bar());
    }
}
