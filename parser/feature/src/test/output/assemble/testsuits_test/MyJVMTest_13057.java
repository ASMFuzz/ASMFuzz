import java.util.*;
import java.nio.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_13057 {

    static MacSpi macParam1 = null;

    static String macParam2Param1 = "{F$*{Zo?d/";

    static double macParam2Param2 = 0d;

    static String macParam2Param3 = "whvRSx0fSt";

    static Provider macParam2 = new AuthProvider(macParam2Param1, macParam2Param2, macParam2Param3);

    static String macParam3 = "#AS}A\"}\"'0";

    static Mac mac = new Mac(macParam1, macParam2, macParam3);

    static byte[] macValue = { -121, -67, -91, -63, 28, -18, 49, -67, -80, 42 };

    static ByteBuffer b = null;

    static Random random = new Random();

    ByteBuffer verify(Mac mac, byte[] macValue, ByteBuffer b, Random random) throws Exception {
        int lim = b.limit();
        b.limit(random.nextInt(lim));
        mac.update(b);
        if (b.hasRemaining()) {
            throw new Exception("Buffer not consumed");
        }
        b.limit(lim);
        mac.update(b);
        if (b.hasRemaining()) {
            throw new Exception("Buffer not consumed");
        }
        byte[] newMacValue = mac.doFinal();
        if (Arrays.equals(macValue, newMacValue) == false) {
            throw new Exception("Mac did not verify");
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13057().verify(mac, macValue, b, random);
    }
}
