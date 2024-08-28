import java.io.*;

public class MyJVMTest_4308 {

    static String dir = "ES+hbv;i~3";

    static String name = "HJ;T:cRU9B";

    PrintWriter getPrintWriter(String dir, String name) throws FileNotFoundException {
        FileOutputStream stream = new FileOutputStream(new File(dir, name));
        return new PrintWriter(stream, true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4308().getPrintWriter(dir, name));
    }
}
