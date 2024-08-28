import java.io.*;
import java.nio.channels.*;

public class MyJVMTest_4263 {

    static String s = "f+cTW(PH|#";

    String fail(String s) {
        throw new RuntimeException(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4263().fail(s);
    }
}
