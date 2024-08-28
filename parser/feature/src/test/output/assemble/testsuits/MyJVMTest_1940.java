import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_1940 {

    static int Init1Tick = 3;

    static int Init4Tick = 0;

    int bat() {
        return Init4Tick;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1940().bat());
    }
}
