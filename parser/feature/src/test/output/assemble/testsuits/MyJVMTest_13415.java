import java.security.*;
import java.util.*;

public class MyJVMTest_13415 {

    static byte[] input1 = { (byte) 0x1, (byte) 0x2, (byte) 0x3 };

    static byte[] input2 = { (byte) 0x4, (byte) 0x5, (byte) 0x6 };

    static MessageDigest md = null;

    void run() throws Exception {
        md.update(input1);
        MessageDigest md2;
        try {
            md2 = (MessageDigest) md.clone();
        } catch (CloneNotSupportedException cnse) {
            System.out.println(md.getAlgorithm() + ": clone unsupported");
            return;
        }
        md.update(input2);
        md2.update(input2);
        if (!Arrays.equals(md.digest(), md2.digest())) {
            throw new Exception(md.getAlgorithm() + ": comparison failed");
        } else {
            System.out.println(md.getAlgorithm() + ": passed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13415().run();
    }
}
