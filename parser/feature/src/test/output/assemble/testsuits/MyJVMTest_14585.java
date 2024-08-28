import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_14585 {

    void go() throws Exception {
        Charset.forName("");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14585().go();
    }
}
