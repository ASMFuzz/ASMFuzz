import java.io.*;
import java.nio.file.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_14571 {

    static byte[] data = { -97, -113, 78, 22, -127, -107, 109, -74, -5, -37 };

    static Map<Integer, List<byte[]>> cache = new HashMap<>();

    static char[] hexCode = "0123456789ABCDEF".toCharArray();

    String printHexBinary(byte[] data) {
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14571().printHexBinary(data));
    }
}
