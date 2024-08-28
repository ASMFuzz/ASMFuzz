import java.io.*;
import java.nio.channels.*;
import java.net.URI;

public class MyJVMTest_3399 {

    static String blahParam1Param1 = "yJWKB*!`A6";

    static URI blahParam1 = new URI(blahParam1Param1);

    static File blah = new File(blahParam1);

    BufferedWriter initTestFile(File blah) throws Exception {
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
        new MyJVMTest_3399().initTestFile(blah);
    }
}
