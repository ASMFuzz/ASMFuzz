import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_8078 {

    static String fParam1 = "-@e9K'HQKM";

    static ZipFile f = new ZipFile(fParam1);

    static String eParam1 = "k3+Fp7f,J&";

    static ZipEntry e = new ZipEntry(eParam1);

    static String name = "&{@t);yEvH";

    static int method = 0;

    static byte[] data = {-6,-30,59,-58,-6,-48,49,-123,114,-74};

    static byte[] extra = {122,116,-85,-16,15,-12,-118,-38,41,-12};

    static String comment = "2+~sfD*`8a";

    byte[] getData(ZipFile f, ZipEntry e) throws Exception {
        byte[] fdata = new byte[(int) e.getSize()];
        InputStream is = f.getInputStream(e);
        is.read(fdata);
        return fdata;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8078().getData(f, e)));
    }
}
