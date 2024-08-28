import java.io.*;

public class MyJVMTest_13679 {

    static String dir = "!afB6h\"Vwk";

    static String name = "Ies $%Nfx2";

    PrintWriter getPrintWriter(String dir, String name) throws FileNotFoundException {
        FileOutputStream stream = new FileOutputStream(new File(dir, name));
        return new PrintWriter(stream, true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13679().getPrintWriter(dir, name));
    }
}
