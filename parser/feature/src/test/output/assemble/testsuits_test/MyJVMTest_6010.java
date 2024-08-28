import java.io.*;
import java.util.jar.*;
import java.net.URI;

public class MyJVMTest_6010 {

    static String fromParam1Param1 = "~X~8a)4(}Y";

    static String fromParam1Param2 = "#cbP8uQ6r\\";

    static String fromParam1Param3 = "?6<=\"q,BH2";

    static String fromParam1Param4 = "WybLq sTlE";

    static URI fromParam1 = new URI(fromParam1Param1, fromParam1Param2, fromParam1Param3, fromParam1Param4);

    static File from = new File(fromParam1);

    static String toParam1 = "{{Z;Z%lDii";

    static File to = new File(toParam1);

    FileOutputStream copy(File from, File to) throws IOException {
        FileInputStream in = new FileInputStream(from);
        FileOutputStream out = new FileOutputStream(to);
        try {
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) != -1) out.write(buf, 0, n);
        } finally {
            in.close();
            out.close();
        }
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6010().copy(from, to);
    }
}
