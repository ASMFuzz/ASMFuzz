import java.util.*;
import java.util.Locale.*;
import static java.util.Locale.FilteringMode.*;
import static java.util.Locale.LanguageRange.*;

public class MyJVMTest_1840 {

    static boolean err = false;

    void testConstructors() {
        boolean error = false;
        LanguageRange lr;
        String range;
        double weight;
        range = "en-Latn-1234567890";
        try {
            lr = new LanguageRange(range);
            error = true;
            System.err.println("    IAE should be thrown for LanguageRange(" + range + ").");
        } catch (IllegalArgumentException ex) {
        }
        range = null;
        try {
            lr = new LanguageRange(range);
            error = true;
            System.err.println("    NPE should be thrown for LanguageRange(" + range + ").");
        } catch (NullPointerException ex) {
        }
        range = null;
        weight = 0.8;
        try {
            lr = new LanguageRange(range, weight);
            error = true;
            System.err.println("    NPE should be thrown for LanguageRange(" + range + ", " + weight + ").");
        } catch (NullPointerException ex) {
        }
        range = "elvish";
        try {
            lr = new LanguageRange(range);
        } catch (Exception ex) {
            error = true;
            System.err.println("    " + ex + " should not be thrown for LanguageRange(" + range + ").");
        }
        range = "de-DE";
        try {
            lr = new LanguageRange(range);
        } catch (Exception ex) {
            error = true;
            System.err.println("    " + ex + " should not be thrown for LanguageRange(" + range + ").");
        }
        range = "ar";
        weight = 0.8;
        try {
            lr = new LanguageRange(range, weight);
        } catch (Exception ex) {
            error = true;
            System.err.println("    " + ex + " should not be thrown for LanguageRange(" + range + ", " + weight + ").");
        }
        range = "ja";
        weight = -0.8;
        try {
            lr = new LanguageRange(range, weight);
            error = true;
            System.err.println("    IAE should be thrown for LanguageRange(" + range + ", " + weight + ").");
        } catch (IllegalArgumentException ex) {
        }
        range = "Elvish";
        weight = 3.0;
        try {
            lr = new LanguageRange(range, weight);
            error = true;
            System.err.println("    IAE should be thrown for LanguageRange(" + range + ", " + weight + ").");
        } catch (IllegalArgumentException ex) {
        }
        String[] illformedRanges = { "-ja", "ja--JP", "en-US-", "a4r", "ar*", "ar-*EG", "", "abcdefghijklmn", "ja-J=", "ja-opqrstuvwxyz" };
        for (String r : illformedRanges) {
            try {
                lr = new LanguageRange(r);
                error = true;
                System.err.println("    IAE should be thrown for LanguageRange(" + r + ").");
            } catch (IllegalArgumentException ex) {
            }
        }
        if (error) {
            err = true;
            System.err.println("  testConstructors() failed.");
        } else {
            System.out.println("  testConstructors() passed.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1840().testConstructors();
    }
}
