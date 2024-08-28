import java.util.*;
import java.security.*;

public class MyJVMTest_6137 {

    static MessageDigest md = null;

    static int arrayLen = 9;

    static int ofs = -669906321;

    static int len = -569162874;

    MessageDigest outOfBounds(MessageDigest md, int arrayLen, int ofs, int len) throws Exception {
        try {
            md.reset();
            md.update(new byte[arrayLen], ofs, len);
            throw new Exception("invalid call succeeded");
        } catch (RuntimeException e) {
        }
        return md;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6137().outOfBounds(md, arrayLen, ofs, len);
    }
}
