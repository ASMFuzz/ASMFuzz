import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_2968 {

    static int Init1Tick = 0;

    static int Init2Tick = 0;

    int bar() {
        return Init2Tick;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2968().bar());
    }
}
