import java.util.*;
import java.util.Locale.*;
import static java.util.Locale.FilteringMode.*;
import static java.util.Locale.LanguageRange.*;

public class MyJVMTest_5582 {

    static boolean err = false;

    void test_equals() {
        boolean error = false;
        LanguageRange lr1 = new LanguageRange("ja", 1.0);
        LanguageRange lr2 = new LanguageRange("ja");
        LanguageRange lr3 = new LanguageRange("ja", 0.1);
        LanguageRange lr4 = new LanguageRange("en", 1.0);
        if (!lr1.equals(lr2)) {
            error = true;
            System.err.println("    LanguageRange(LR(ja, 1.0)).equals(LR(ja)) should return true.");
        }
        if (lr1.equals(lr3)) {
            error = true;
            System.err.println("    LanguageRange(LR(ja, 1.0)).equals(LR(ja, 0.1)) should return false.");
        }
        if (lr1.equals(lr4)) {
            error = true;
            System.err.println("    LanguageRange(LR(ja, 1.0)).equals(LR(en, 1.0)) should return false.");
        }
        if (lr1.equals(null)) {
            error = true;
            System.err.println("    LanguageRange(LR(ja, 1.0)).equals(null) should return false.");
        }
        if (lr1.equals("")) {
            error = true;
            System.err.println("    LanguageRange(LR(ja, 1.0)).equals(\"\") should return false.");
        }
        if (error) {
            err = true;
            System.err.println("  test_equals() failed.");
        } else {
            System.out.println("  test_equals() passed.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5582().test_equals();
    }
}
