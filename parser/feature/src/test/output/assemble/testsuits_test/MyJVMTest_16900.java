import java.util.*;
import java.util.Locale.*;
import static java.util.Locale.FilteringMode.*;
import static java.util.Locale.LanguageRange.*;

public class MyJVMTest_16900 {

    static boolean err = false;

    void testConstants() {
        boolean error = false;
        if (MIN_WEIGHT != 0.0) {
            error = true;
            System.err.println("    MIN_WEIGHT should be 0.0 but got " + MIN_WEIGHT);
        }
        if (MAX_WEIGHT != 1.0) {
            error = true;
            System.err.println("    MAX_WEIGHT should be 1.0 but got " + MAX_WEIGHT);
        }
        if (error) {
            err = true;
            System.err.println("  testConstants() failed.");
        } else {
            System.out.println("  testConstants() passed.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16900().testConstants();
    }
}
