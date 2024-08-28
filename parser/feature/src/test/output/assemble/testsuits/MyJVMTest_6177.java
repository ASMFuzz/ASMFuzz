import java.util.*;
import java.util.zip.*;
import java.io.*;

public class MyJVMTest_6177 {

    static byte[] isParam1 = { -13, -19, 23, 4, 35, 2, -55, 18, -35, -29 };

    static int isParam2 = 379;

    static int isParam3 = 717;

    static InputStream is = new ByteArrayInputStream(isParam1, isParam2, isParam3);

    String contents(InputStream is) throws Exception {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = is.read()) != -1) sb.append((char) c);
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6177().contents(is));
    }
}
