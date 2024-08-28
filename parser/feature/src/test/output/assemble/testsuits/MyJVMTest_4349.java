import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_4349 {

    static int exitcode = 0;

    static boolean showerrors = true;

    static boolean showresults = false;

    static boolean fringe = true;

    static boolean forceerror = false;

    static boolean fulltest = true;

    static boolean hwonly = false;

    static BufferedImage bimg = null;

    int usage(int exitcode) {
        System.err.println("usage: java PolyVertTest [<option>]*");
        System.err.println("    -usage         " + "print this usage summary");
        System.err.println("    -count         " + "run all tests and accumulate error counts");
        System.err.println("    -forceerror    " + "force at least one error in each test");
        System.err.println("    -fringe        " + "draw a yellow fringe around problems");
        System.err.println("    -showerrors    " + "display results window for tests with problems");
        System.err.println("    -showresults   " + "display results window for all tests");
        System.err.println("    -quicktest     " + "only run test cases reported in bug reports");
        System.err.println("    -fulltest      " + "run full suite of test cases for a 'unit test'");
        System.err.println("    -hwonly        " + "only run tests for screen and VolatileImage");
        System.exit(exitcode);
        return exitcode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4349().usage(exitcode);
    }
}
