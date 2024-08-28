import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_46 {

    static String blahParam1Param1 = "/pqr(~.Ykn";

    static String blahParam1Param2 = "l6AvWA)ncp";

    static File blahParam1 = new File(blahParam1Param1, blahParam1Param2);

    static String blahParam2 = "-xr;hJcfB ";

    static File blah = new File(blahParam1, blahParam2);

    BufferedWriter initTestFile(File blah) throws Exception {
        FileOutputStream fos = new FileOutputStream(blah);
        BufferedWriter awriter = new BufferedWriter(new OutputStreamWriter(fos, "8859_1"));
        for (int i = 0; i < 4; i++) {
            String number = new Integer(i).toString();
            for (int h = 0; h < 4 - number.length(); h++) awriter.write("0");
            awriter.write("" + i);
            awriter.newLine();
        }
        awriter.flush();
        awriter.close();
        return awriter;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_46().initTestFile(blah);
    }
}
