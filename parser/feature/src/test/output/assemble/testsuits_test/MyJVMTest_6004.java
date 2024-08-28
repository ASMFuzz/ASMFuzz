import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_6004 {

    static String event = "\\wB4ZYbEYl";

    static int TICK = 0;

    static int Init1Tick = 3;

    int tick(String event) {
        int n = ++TICK;
        System.out.println("event #" + n + " = " + event);
        return n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6004().tick(event));
    }
}
