import java.util.*;
import java.security.*;

public class MyJVMTest_15606 {

    static MessageDigest md = null;

    static int arrayLen = 1282799851;

    static int ofs = 9;

    static int len = 0;

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
        new MyJVMTest_15606().outOfBounds(md, arrayLen, ofs, len);
    }
}
