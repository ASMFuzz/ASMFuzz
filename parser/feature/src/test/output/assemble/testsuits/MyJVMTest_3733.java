import java.io.*;

public class MyJVMTest_3733 {

    static Writer outParam1 = new CharArrayWriter();

    static boolean outParam2 = true;

    static PrintWriter out = new PrintWriter(outParam1, outParam2);

    static Writer errParam1 = new CharArrayWriter();

    static boolean errParam2 = false;

    static PrintWriter err = new PrintWriter(errParam1, errParam2);

    static String args = "s9sAl<:A\\{";

    int run(PrintWriter out, PrintWriter err, String... args) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3733().run(out, err, args));
    }
}
