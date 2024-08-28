import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_16165 {

    void bug6639450() throws Exception {
        byte[] bytes1 = "\\".getBytes("IBM949");
        "\\".getBytes("IBM949C");
        byte[] bytes2 = "\\".getBytes("IBM949");
        if (bytes1.length != 1 || bytes2.length != 1 || bytes1[0] != (byte) 0x82 || bytes2[0] != (byte) 0x82)
            throw new Exception("IBM949/IBM949C failed");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16165().bug6639450();
    }
}
