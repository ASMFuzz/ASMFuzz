import java.text.*;
import java.util.*;

public class MyJVMTest_15899 {

    static String[][] s = { { "[7s`pFp3eU", "]@:F8@1+;@", ";,8\\#(|{q7", "R3B *Y 0\"v", "pjujUG|w,,", "KV|IojE}H(", "=y`]HF{,Z/", ";ck}14<$*K", "|F'LN]e}_1", "|p5KZt*EB[" }, { "l@H%{w*]>\"", "%=aRsf7`2a", "uzgZ]KuXyF", " O^cN&Rxtt", ".C>c3oRqu5", "HfQ1`Nv' _", "_NtM83x4rx", "ddH eP*[`_", "|Q29]@LM,2", "pJ5D/`2/L8" } };

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
        new MyJVMTest_15899().doEquals(s);
    }
}
