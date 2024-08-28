import java.text.*;
import java.util.*;

public class MyJVMTest_16611 {

    static String[][] s = { { "Wb7,)*6#V&", "Y{,q5q7CM_", ";abqD!9bpV", ",84,6]k@hU", ".mqqW[S(hz", "?o-XUS-rZJ", ":?^{s7\"e>}", ";^/d5v62H ", "C`Hl#Y0&i>", "?o<9RgI#4M" }, { "s- D6Khh(x", "cks)<T`t6G", "w7Q44DGB}K", "AG~)>hnqQ!", "kc;6:K%R!T", "j!d#Ho7z+t", "]`QNDFE>,E", "_TPPiK*;9/", "?JzO'W%78;", "zc`(Y?0C9 " } };

    static int expectedValue = -1249901473;

    static int strength = 7;

    static int decomp = 0;

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
        new MyJVMTest_16611().doCompare(s, expectedValue, strength, decomp);
    }
}
