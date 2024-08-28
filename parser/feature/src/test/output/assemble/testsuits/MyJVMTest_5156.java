import java.io.*;
import java.nio.file.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_5156 {

    static byte[] data = { -89, -18, -81, -52, -40, 39, -15, 39, -97, -71 };

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
        System.out.println(new MyJVMTest_5156().printHexBinary(data));
    }
}
