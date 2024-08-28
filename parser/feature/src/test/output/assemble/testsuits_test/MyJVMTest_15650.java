import java.util.*;
import java.util.zip.*;
import java.io.*;

public class MyJVMTest_15650 {

    static byte[] isParam1 = { 61, -29, 50, -84, -71, -59, 52, -66, 4, 2 };

    static InputStream is = new ByteArrayInputStream(isParam1);

    String contents(InputStream is) throws Exception {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = is.read()) != -1) sb.append((char) c);
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15650().contents(is));
    }
}
