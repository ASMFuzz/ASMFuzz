import java.io.*;
import java.net.URI;

public class MyJVMTest_10604 {

    static String fromParam1Param1 = "PeOeb'+\\0=";

    static String fromParam1Param2 = "]Q80v.$i7J";

    static String fromParam1Param3 = "?{.D+:P#OT";

    static URI fromParam1 = new URI(fromParam1Param1, fromParam1Param2, fromParam1Param3);

    static File from = new File(fromParam1);

    static String toParam1 = "&E$PSV\\G?8";

    static String toParam2 = ">,eghC@r}{";

    static File to = new File(toParam1, toParam2);

    int copyFile(File from, File to) throws Exception {
        System.out.println("Copying '" + from + "' to '" + to + "'");
        int i = 0;
        byte[] buff = new byte[1000];
        FileInputStream fis = new FileInputStream(from);
        FileOutputStream fos = new FileOutputStream(to);
        int read = 1;
        while (true && read > 0) {
            read = fis.read(buff);
            i += read;
            if (read > -1)
                fos.write(buff, 0, read);
        }
        fos.flush();
        fos.close();
        fis.close();
        return read;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10604().copyFile(from, to);
    }
}
