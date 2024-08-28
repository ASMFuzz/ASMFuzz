import java.text.*;
import java.util.*;

public class MyJVMTest_8206 {

    static String[][] s = { { ",rwTg`_E(O", "T`?,pc.tvO", "s*qzYLaPa@", "UDHr,fM>2w", "a;DcIF2\")K", "%Xm$ u#e\">", "4u_x@jM2fG", "Zf[2sPMG~e", "oY.4zVSWk\\", "i>QK5b2ztk" }, { "C6:N[B2.-H", "91W(rAk5'a", "(tMdERuQ$Q", "kTZ?M.Q<))", "-VO= 0[FsE", "@h)k~:[O 2", "[+m\"|eb2%{", "~9dgW$;L-Z", "NmZ\\dXXNb3", "bZEJf.yS^g" } };

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
        new MyJVMTest_8206().doCompare(s);
    }
}
