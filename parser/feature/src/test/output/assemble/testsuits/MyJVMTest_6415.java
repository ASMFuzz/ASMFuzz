import java.text.*;
import java.util.*;

public class MyJVMTest_6415 {

    static String[][] s = { { "!>yF#JF.cy", "^ZG\\``<&E+", "`m[})xAP[B", "g-]5EaS+~=", "FEeh1I,B,G", ":AD<Pb+Pbt", "nhho#ZZ$XU", "9{#<%P HD/", "TJrF|Tzx,f", "Ow8\\\"r?.Pj" }, { "3B`(@Fv2JT", "B(i&f?r13'", "0buho69]hI", "@-,WiR&xb4", "IP#8m'Klq4", "EIG4j1pPx6", "f&\\g\",fSFc", "yUA@(1|Y|q", "'K3N^D65/p", "gk@ANH}43y" } };

    static Collator col = Collator.getInstance(Locale.KOREA);

    static int result = 0;

    String[][] doEquals(String[][] s) {
        for (int i = 0; i < s.length; i++) {
            if (!col.equals(s[i][0], s[i][1])) {
                result++;
                System.err.println("TERTIARY: The first string should be equals to the second string:  " + s[i][2] + "  compare() returned " + col.compare(s[i][0], s[i][1] + "."));
            }
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6415().doEquals(s);
    }
}
