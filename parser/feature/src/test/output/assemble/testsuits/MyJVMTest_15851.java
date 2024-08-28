import java.util.*;
import java.util.Locale.*;
import static java.util.Locale.FilteringMode.*;
import static java.util.Locale.LanguageRange.*;

public class MyJVMTest_15851 {

    static boolean err = false;

    void test_getWeight() {
        boolean error = false;
        String range = "ja";
        double weight = 0.5;
        LanguageRange lr = new LanguageRange(range, weight);
        if (lr.getWeight() != weight) {
            error = true;
            System.err.println("    LanguageRange.getWeight() returned unexpected value. Expected: " + weight + ", got: " + lr.getWeight());
        }
        range = "ja";
        weight = MAX_WEIGHT;
        lr = new LanguageRange(range);
        if (!lr.getRange().equals(range) || lr.getWeight() != MAX_WEIGHT) {
            error = true;
            System.err.println("    LanguageRange.getWeight() returned unexpected value. Expected: " + weight + ", got: " + lr.getWeight());
        }
        if (error) {
            err = true;
            System.err.println("  test_getWeight() failed.");
        } else {
            System.out.println("  test_getWeight() passed.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15851().test_getWeight();
    }
}
