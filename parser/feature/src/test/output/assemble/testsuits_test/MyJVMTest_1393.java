import java.io.*;
import java.net.URI;

public class MyJVMTest_1393 {

    static String fromParam1 = "!jhI7,-y 0";

    static File from = new File(fromParam1);

    static String toParam1Param1 = "e~\"XEP*8VV";

    static String toParam1Param2 = ",Jy+rT:K5;";

    static String toParam1Param3 = "U %D&ndK!h";

    static String toParam1Param4 = "uPeS.JJ1~C";

    static String toParam1Param5 = "o&0Z?ww9^y";

    static URI toParam1 = new URI(toParam1Param1, toParam1Param2, toParam1Param3, toParam1Param4, toParam1Param5);

    static File to = new File(toParam1);

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
        new MyJVMTest_1393().copyFile(from, to);
    }
}
