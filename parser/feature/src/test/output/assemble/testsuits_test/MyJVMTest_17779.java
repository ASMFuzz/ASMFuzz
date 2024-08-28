import java.text.*;
import java.util.*;

public class MyJVMTest_17779 {

    static String[][] s = { { "w%i9T)6Yne", "dBg5t)OTJ(", "UAMwDlS:X$", "~ROoO?q~t_", "v.k_cs8#\"U", "tS+A)$v1,a", "VA[;:7Y x}", "&E<ES\\odfr", "9AdXa7'!#o", "w3Y2-FarT#" }, { "Gg->+?Io6_", "@&QcGt6D/V", "yFM$j8uo&r", "[%fa$(\\\\Z-", "~Ub$JwV2Vm", "e_M;BkRDe{", "2}&s)GMnw(", "A\\m`;nesg=", "\\+*&429o~m", "_E7]9Fdbv}" } };

    static Collator col = Collator.getInstance(Locale.KOREA);

    static int result = 0;

    String[][] doCompare(String[][] s) {
        int value;
        for (int i = 0; i < s.length; i++) {
            if ((value = col.compare(s[i][0], s[i][1])) > -1) {
                result++;
                System.err.println("TERTIARY: The first string should be less than the second string:  " + s[i][2] + "  compare() returned " + value + ".");
            }
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17779().doCompare(s);
    }
}
