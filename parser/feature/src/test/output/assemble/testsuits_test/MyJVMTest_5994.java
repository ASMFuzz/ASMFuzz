import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_5994 {

    static SSLEngine ssle = null;

    static ByteBuffer[] appData = { null, null, null, null, null, null, null, null, null, null };

    static int offset = 0;

    static int len = 1;

    static ByteBuffer netData = null;

    ByteBuffer tryReadOnly(SSLEngine ssle, ByteBuffer[] appData, int offset, int len, ByteBuffer netData) throws Exception {
        try {
            if (netData.isReadOnly()) {
                ssle.wrap(appData, offset, len, netData);
                throw new Exception();
            }
        } catch (ReadOnlyBufferException e) {
            System.out.println("Caught right exception");
        }
        try {
            if (!netData.isReadOnly()) {
                ssle.unwrap(netData, appData, offset, len);
                throw new Exception();
            }
        } catch (ReadOnlyBufferException e) {
            System.out.println("Caught right exception");
        }
        return netData;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5994().tryReadOnly(ssle, appData, offset, len, netData);
    }
}
