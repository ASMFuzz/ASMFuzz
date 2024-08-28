import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_4216 {

    static byte[] PLAINTEXT = new byte[30];

    static Cipher ci = null;

    static byte[] in = null;

    static byte[] expected = null;

    static byte[] out = null;

    static int outOffset = 0;

    byte[] init(byte[] in, byte[] expected) {
        this.in = (byte[]) in.clone();
        this.expected = (byte[]) expected.clone();
        this.out = new byte[expected.length];
        this.outOffset = 0;
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4216().init(in, expected);
    }
}
