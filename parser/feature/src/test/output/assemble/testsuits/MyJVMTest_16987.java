import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_16987 {

    void bug6569191() throws Exception {
        byte[] bs = new byte[] { (byte) 0x81, (byte) 0xad, (byte) 0x81, (byte) 0xae, (byte) 0x81, (byte) 0xaf, (byte) 0x81, (byte) 0xb0, (byte) 0x85, (byte) 0x81, (byte) 0x85, (byte) 0x87, (byte) 0x85, (byte) 0xe0, (byte) 0x85, (byte) 0xf0 };
        String s = new String(bs, "Cp943");
        if (!"\ufffd\uff6d\ufffd\uff6e\ufffd\uff6f\ufffd\uff70\ufffd\u2266\u32a4\u7165\ufffd".equals(s))
            throw new Exception("Cp943 failed");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16987().bug6569191();
    }
}
