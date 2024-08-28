import java.io.*;

public class MyJVMTest_8265 {

    static String outParam1 = "UP:`Qu=p`,";

    static PrintStream out = new PrintStream(outParam1);

    static boolean verbose = false;

    int checkIt(PrintStream out, boolean verbose) {
        if (verbose)
            out.println("NEW redefclass002r (" + this + "): inside the checkIt()");
        return 73;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8265().checkIt(out, verbose));
    }
}
