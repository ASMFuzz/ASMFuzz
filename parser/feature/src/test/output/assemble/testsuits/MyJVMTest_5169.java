import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_5169 {

    void go() throws Exception {
        Charset.forName("");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5169().go();
    }
}
