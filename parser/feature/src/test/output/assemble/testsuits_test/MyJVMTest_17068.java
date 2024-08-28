import java.security.Permission;

public class MyJVMTest_17068 {

    static String channel = "[>qA>4d|i&";

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

    static int mask = 7;

    static String cname = "0 o5/je41w";

    static boolean wildcard = false;

    static int[] numrange = {4,0,1133618405,8,0,-131534982,0,3,2,0};

    static int NUM_MIN = 1;

    static int NUM_MAX = 128;

    int init(String channel, int mask) {
        int sep = channel.indexOf(':');
        if (sep != -1) {
            String num = channel.substring(sep + 1);
            cname = channel.substring(0, sep);
            try {
                numrange = parseNum(num);
            } catch (Exception e) {
                throw new IllegalArgumentException("invalid num range: " + num);
            }
        } else {
            numrange = new int[] { NUM_MIN, NUM_MAX };
        }
        return sep;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17068().init(channel, mask);
    }
}
