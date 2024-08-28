import java.io.*;

public class MyJVMTest_5529 {

    static String fParam1 = "cRW>ly+5ew";

    static String fParam2 = "\\gS#)[!do$";

    static File f = new File(fParam1, fParam2);

    OutputStream touch(File f) throws IOException {
        OutputStream o = new FileOutputStream(f);
        o.close();
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5529().touch(f);
    }
}
