import java.io.*;
import java.nio.channels.*;

public class MyJVMTest_13632 {

    static String s = "ewtl%KpfV8";

    String fail(String s) {
        throw new RuntimeException(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13632().fail(s);
    }
}
