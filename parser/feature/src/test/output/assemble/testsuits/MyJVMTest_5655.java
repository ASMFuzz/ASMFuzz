import java.text.*;
import java.util.*;

public class MyJVMTest_5655 {

    static double[] nfParam1 = { Double.NaN, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0.8108002010348596, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, 0.06104754107029564, Double.NaN };

    static String[] nfParam2 = { "=im8nri-|x", "yX5.+56_K!", "npFjH;Qq[F", "x18q.GB>5j", "0PO8F>A/M:", "YUyNw@Fn,M", "JFdId.|O,@", "UeR8+Aw!W/", "M m'i}/2ve", ")vZq_}A62S" };

    static NumberFormat nf = new ChoiceFormat(nfParam1, nfParam2);

    static int given = 7;

    static String expected = "('@Obin!lG";

    static String locale = "8)SoYkti}-";

    static boolean err = false;

    static boolean verbose = false;

    int testNumberFormatFormatting(NumberFormat nf, int given, String expected, String locale) {
        String str = nf.format(given);
        if (expected.equals(str)) {
            if (verbose) {
                System.out.print("  Passed: NumberFormat(" + locale);
                System.out.println(").format(" + given + ")");
                System.out.println("      ---> \"" + str + "\"");
            }
        } else {
            err = true;
            System.err.print("  Failed: Unexpected NumberFormat(" + locale);
            System.err.println(").format(" + given + ") result.");
            System.err.println("      Expected: \"" + expected + "\"");
            System.err.println("      Got:      \"" + str + "\"");
        }
        return given;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5655().testNumberFormatFormatting(nf, given, expected, locale);
    }
}
