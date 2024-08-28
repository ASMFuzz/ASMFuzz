import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_7012 {

    void go() throws Exception {
        Charset.isSupported("");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7012().go();
    }
}
