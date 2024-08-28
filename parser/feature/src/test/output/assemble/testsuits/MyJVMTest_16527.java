import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_16527 {

    void go() throws Exception {
        Charset.isSupported("");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16527().go();
    }
}
