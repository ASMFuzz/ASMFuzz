import java.text.*;
import java.util.*;

public class MyJVMTest_7092 {

    static String[][] s = { { "U5h3=3Pa,l", "WK/zoU(i}8", "PSYKdKc}sH", "|n/^seE= y", "=c+4fdG&Ua", "Y6NGrL8V:}", "bzSChFKu\"v", "(a9XMwY].~", "v;PUM6dy<3", "Pw/[I%(VtB" }, { "!~Ii^QhX.U", "uD'Xx Xfg9", "GQ)fS\\(Z`{", "<Ve7oKa!Wu", "QxA7b=z^7{", "mypQwA^S$)", "6XWrmLIbx2", "g_i\"q8IytE", "s][-!t[!ya", "?wMG3jA[<[" } };

    static int expectedValue = 1;

    static int strength = 6;

    static int decomp = 6;

    static String[] decomp_name = { "NO_DECOMP", "CANONICAL_DECOMP", "FULL_DECOMP" };

    static String[] strength_name = { "PRIMARY", "SECONDARY", "TERTIARY" };

    static Collator col = Collator.getInstance(Locale.JAPAN);

    static int result = 0;

    String[][] doCompare(String[][] s, int expectedValue, int strength, int decomp) {
        int value;
        for (int i = 0; i < s.length; i++) {
            if ((value = col.compare(s[i][0], s[i][1])) != expectedValue) {
                result++;
                System.err.println(strength_name[strength] + ": compare() returned unexpected value.(" + value + ") on " + decomp_name[decomp] + "     Expected(" + expectedValue + ") for " + s[i][2]);
            }
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7092().doCompare(s, expectedValue, strength, decomp);
    }
}
