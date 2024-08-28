import java.io.*;
import java.util.jar.*;
import java.net.URI;

public class MyJVMTest_15465 {

    static String fromParam1 = "X8L1A,jpP=";

    static String fromParam2 = "VW\\?:65(uj";

    static File from = new File(fromParam1, fromParam2);

    static String toParam1Param1 = "T_)PnR4.1v";

    static String toParam1Param2 = "0/@}RA?Wx8";

    static String toParam1Param3 = "x'D,|d&Q`a";

    static int toParam1Param4 = 353;

    static String toParam1Param5 = "`G3#V% 8AO";

    static String toParam1Param6 = ":kVkWx($kW";

    static String toParam1Param7 = "x5W'0|N@EN";

    static URI toParam1 = new URI(toParam1Param1, toParam1Param2, toParam1Param3, toParam1Param4, toParam1Param5, toParam1Param6, toParam1Param7);

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
        new MyJVMTest_15465().copy(from, to);
    }
}
