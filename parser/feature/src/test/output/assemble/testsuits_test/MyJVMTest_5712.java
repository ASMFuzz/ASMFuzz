import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class MyJVMTest_5712 {

    static byte[] bytes = { 53, -56, -59, -45, -36, -46, 12, -48, 106, 52 };

    static byte[] source = {59,86,94,-81,68,-46,120,-97,-50,60};

    static int count = 1689770851;

    byte[] nextBytes(byte[] bytes) {
        if (bytes.length > source.length - count) {
            throw new RuntimeException("Insufficient random data");
        }
        System.arraycopy(source, count, bytes, 0, bytes.length);
        count += bytes.length;
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5712().nextBytes(bytes);
    }
}
