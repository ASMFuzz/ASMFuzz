import java.io.*;

public class MyJVMTest_14962 {

    static String fParam1 = "Y(69)gknyG";

    static File f = new File(fParam1);

    OutputStream touch(File f) throws IOException {
        OutputStream o = new FileOutputStream(f);
        o.close();
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14962().touch(f);
    }
}
