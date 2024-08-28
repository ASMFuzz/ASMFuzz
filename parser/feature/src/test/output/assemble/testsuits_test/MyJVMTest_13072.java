import java.io.*;

public class MyJVMTest_13072 {

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static PrintWriter out = new PrintWriter(outParam1);

    static int errParam1Param1 = 935;

    static Writer errParam1 = new CharArrayWriter(errParam1Param1);

    static boolean errParam2 = false;

    static PrintWriter err = new PrintWriter(errParam1, errParam2);

    static String args = "X4d?b,\"FQ ";

    int run(PrintWriter out, PrintWriter err, String... args) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13072().run(out, err, args));
    }
}
