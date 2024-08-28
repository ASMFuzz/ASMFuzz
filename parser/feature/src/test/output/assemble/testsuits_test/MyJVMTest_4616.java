import java.security.Permission;
import java.util.Arrays;

public class MyJVMTest_4616 {

    static String num = "P$PgEt?Ffp";

    static int mask = -65156137;

    static boolean wildcard = true;

    static int NUM_MIN = 1;

    static int NUM_MAX = 128;

    int[] parseNum(String num) throws Exception {
        if (num == null || num.equals("") || num.equals("*")) {
            wildcard = true;
            return new int[] { NUM_MIN, NUM_MAX };
        }
        int dash = num.indexOf('-');
        if (dash == -1) {
            int p = 0;
            try {
                p = Integer.parseInt(num);
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("invalid input" + num);
            }
            return new int[] { p, p };
        } else {
            String low = num.substring(0, dash);
            String high = num.substring(dash + 1);
            int l, h;
            if (low.equals("")) {
                l = NUM_MIN;
            } else {
                try {
                    l = Integer.parseInt(low);
                } catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("invalid input" + num);
                }
            }
            if (high.equals("")) {
                h = NUM_MAX;
            } else {
                try {
                    h = Integer.parseInt(high);
                } catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("invalid input" + num);
                }
            }
            if (h < l || l < NUM_MIN || h > NUM_MAX) {
                throw new IllegalArgumentException("invalid num range");
            }
            return new int[] { l, h };
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4616().parseNum(num)));
    }
}
