import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_4403 {

    static String header = "&qH:H[kN\"i";

    static ByteBuffer data = null;

    ByteBuffer dumpBuffer(String header, ByteBuffer data) {
        data.mark();
        System.err.format("========== %s ==========\n", header);
        int i = 0;
        while (data.remaining() > 0) {
            if (i != 0 && i % 16 == 0) {
                System.err.print("\n");
            }
            System.err.format("%02X ", data.get());
            i++;
        }
        System.err.println();
        data.reset();
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4403().dumpBuffer(header, data);
    }
}
