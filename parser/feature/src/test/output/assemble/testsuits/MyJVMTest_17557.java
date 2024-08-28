import java.io.*;

public class MyJVMTest_17557 {

    static String encoding = "#E*3zZ]W-\\";

    int tryEncoding(String encoding) throws java.io.IOException, java.io.UnsupportedEncodingException, java.io.FileNotFoundException {
        String filename = "OUTPUT";
        int goesBadAfter = 8193;
        int i;
        char[] data = new char[goesBadAfter + 1];
        System.out.println("Testing " + encoding);
        for (i = 0; i < goesBadAfter; i++) {
            data[i] = (char) ((i % 0x7f) + 1);
        }
        FileOutputStream fout = new FileOutputStream(filename);
        OutputStreamWriter ow = new OutputStreamWriter(fout, encoding);
        BufferedWriter fd = new BufferedWriter(ow);
        fd.write(data, 0, goesBadAfter);
        fd.close();
        char[] buf = new char[goesBadAfter + 1];
        FileInputStream fin = new FileInputStream("OUTPUT");
        InputStreamReader ir = new InputStreamReader(fin, encoding);
        ir.read(buf, 0, goesBadAfter);
        ir.close();
        for (i = 0; i < goesBadAfter; i++) {
            if (data[i] != buf[i]) {
                System.out.println("ERROR with encoding " + encoding + ": Data wrong at position " + i + "   " + "in: " + (int) data[i] + "   " + "out: " + (int) buf[i]);
                throw new RuntimeException();
            }
        }
        System.out.println("Successfully tested " + encoding);
        return goesBadAfter;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17557().tryEncoding(encoding);
    }
}
