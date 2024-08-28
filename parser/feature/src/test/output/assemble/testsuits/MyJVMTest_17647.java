import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_17647 {

    static String fParam1 = "nW .Do2E~1";

    static ZipFile f = new ZipFile(fParam1);

    static String eParam1 = "@YJa0D$0<Z";

    static ZipEntry e = new ZipEntry(eParam1);

    static String name = "X\"2rj/1Z2'";

    static int method = 7;

    static byte[] data = {68,24,66,-89,-24,124,12,127,-25,17};

    static byte[] extra = {61,-14,-19,-60,47,116,-21,89,-110,-113};

    static String comment = "v6L&Tkw/T&";

    byte[] getData(ZipFile f, ZipEntry e) throws Exception {
        byte[] fdata = new byte[(int) e.getSize()];
        InputStream is = f.getInputStream(e);
        is.read(fdata);
        return fdata;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17647().getData(f, e)));
    }
}
