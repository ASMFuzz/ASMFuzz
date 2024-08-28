import java.io.*;
import java.nio.channels.*;
import java.nio.*;

public class MyJVMTest_2589 {

    static String blahParam1 = "q#f}q:Is%m";

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
        new MyJVMTest_2589().initTestFile(blah);
    }
}
