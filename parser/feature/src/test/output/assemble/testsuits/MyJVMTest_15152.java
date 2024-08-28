import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class MyJVMTest_15152 {

    static byte[] bytes = { -117, -29, -93, 3, -112, 41, 69, 82, -19, -128 };

    static byte[] source = {60,50,48,-26,-9,-37,-47,41,87,67};

    static int count = 0;

    byte[] nextBytes(byte[] bytes) {
        if (bytes.length > source.length - count) {
            throw new RuntimeException("Insufficient random data");
        }
        System.arraycopy(source, count, bytes, 0, bytes.length);
        count += bytes.length;
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15152().nextBytes(bytes);
    }
}
