import java.io.*;
import java.nio.channels.*;
import java.nio.*;
import java.net.URI;

public class MyJVMTest_11868 {

    static String blahParam1Param1 = "y7OXNb-!Lt";

    static String blahParam1Param2 = "gujD|e45\\o";

    static String blahParam1Param3 = "Ri%J~` H;S";

    static String blahParam1Param4 = "<4+$N\\wGqU";

    static String blahParam1Param5 = ">tQ\\K8(WY#";

    static URI blahParam1 = new URI(blahParam1Param1, blahParam1Param2, blahParam1Param3, blahParam1Param4, blahParam1Param5);

    static File blah = new File(blahParam1);

    BufferedWriter initTestFile(File blah) throws IOException {
        FileOutputStream fos = new FileOutputStream(blah);
        BufferedWriter awriter = new BufferedWriter(new OutputStreamWriter(fos, "8859_1"));
        for (int i = 0; i < 4000; i++) {
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
        new MyJVMTest_11868().initTestFile(blah);
    }
}
