import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_11176 {

    static int Init1Tick = 2143851652;

    static int Init4Tick = 3;

    int bat() {
        return Init4Tick;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11176().bat());
    }
}
