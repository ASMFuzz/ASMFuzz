import java.io.*;
import java.nio.channels.*;

public class MyJVMTest_7883 {

    static File blah = null;

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
        new MyJVMTest_7883().initTestFile(blah);
    }
}
