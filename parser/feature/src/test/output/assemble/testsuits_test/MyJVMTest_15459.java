import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_15459 {

    static String event = "&Peqi!{8ze";

    static int TICK = 5;

    static int Init1Tick = -1267892256;

    int tick(String event) {
        int n = ++TICK;
        System.out.println("event #" + n + " = " + event);
        return n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15459().tick(event));
    }
}
