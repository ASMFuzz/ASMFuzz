import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.URI;

public class MyJVMTest_9185 {

    static String blahParam1Param1Param1 = "9yri}uo67!";

    static String blahParam1Param1Param2 = "\"H};V%5JJn";

    static String blahParam1Param1Param3 = "{M)1p[u\"sW";

    static String blahParam1Param1Param4 = "Qe)G|L#OpD";

    static URI blahParam1Param1 = new URI(blahParam1Param1Param1, blahParam1Param1Param2, blahParam1Param1Param3, blahParam1Param1Param4);

    static File blahParam1 = new File(blahParam1Param1);

    static String blahParam2 = "'ZJH&0v-kD";

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
        new MyJVMTest_9185().initTestFile(blah);
    }
}
