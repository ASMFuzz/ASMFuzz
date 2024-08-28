import java.util.*;
import java.util.Locale.*;
import static java.util.Locale.FilteringMode.*;
import static java.util.Locale.LanguageRange.*;

public class MyJVMTest_10127 {

    static boolean err = false;

    void test_getRange() {
        boolean error = false;
        String range = "ja";
        double weight = 0.5;
        LanguageRange lr = new LanguageRange(range, weight);
        if (!lr.getRange().equals(range)) {
            error = true;
            System.err.println("    LanguageRange.getRange() returned unexpected value. Expected: " + range + ", got: " + lr.getRange());
        }
        range = "en-US";
        weight = 0.5;
        lr = new LanguageRange(range, weight);
        if (!lr.getRange().equals(range.toLowerCase())) {
            error = true;
            System.err.println("    LanguageRange.getRange() returned unexpected value. Expected: " + range + ", got: " + lr.getRange());
        }
        if (error) {
            err = true;
            System.err.println("  test_getRange() failed.");
        } else {
            System.out.println("  test_getRange() passed.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10127().test_getRange();
    }
}
