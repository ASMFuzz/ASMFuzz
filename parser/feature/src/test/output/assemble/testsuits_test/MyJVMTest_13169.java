public class MyJVMTest_13169 {

    static int[] pos = { 0, 1, 2, 3 };

    static int[] neg = { 0, -1, -2, -3 };

    static int[] max = { 2147483647, 2147483646, 2147483645, 2147483644 };

    static int[] min = { -2147483648, -2147483647, -2147483646, -2147483645 };

    static int[] out = { (int) 2147483648L, (int) -2147483649L, (int) Long.MAX_VALUE, (int) Long.MIN_VALUE };

    void cmplTest_LHS() throws Exception {
        if (0L != pos[0]) {
            throw new Exception("LHS: pos[0] is " + pos[0]);
        }
        if (1L != pos[1]) {
            throw new Exception("LHS: pos[1] is " + pos[1]);
        }
        if (2L != pos[2]) {
            throw new Exception("LHS: pos[2] is " + pos[2]);
        }
        if (3L != pos[3]) {
            throw new Exception("LHS: pos[3] is " + pos[3]);
        }
        if (-0L != neg[0]) {
            throw new Exception("LHS: neg[0] is " + neg[0]);
        }
        if (-1L != neg[1]) {
            throw new Exception("LHS: neg[1] is " + neg[1]);
        }
        if (-2L != neg[2]) {
            throw new Exception("LHS: neg[2] is " + neg[2]);
        }
        if (-3L != neg[3]) {
            throw new Exception("LHS: neg[3] is " + neg[3]);
        }
        if (2147483647L != max[0]) {
            throw new Exception("LHS: max[0] is " + max[0]);
        }
        if (2147483646L != max[1]) {
            throw new Exception("LHS: max[1] is " + max[1]);
        }
        if (2147483645L != max[2]) {
            throw new Exception("LHS: max[2] is " + max[2]);
        }
        if (2147483644L != max[3]) {
            throw new Exception("LHS: max[3] is " + max[3]);
        }
        if (-2147483648L != min[0]) {
            throw new Exception("LHS: min[0] is " + min[0]);
        }
        if (-2147483647L != min[1]) {
            throw new Exception("LHS: min[1] is " + min[1]);
        }
        if (-2147483646L != min[2]) {
            throw new Exception("LHS: min[2] is " + min[2]);
        }
        if (-2147483645L != min[3]) {
            throw new Exception("LHS: min[3] is " + min[3]);
        }
        if (2147483648L == out[0]) {
            throw new Exception("LHS: out[0] is " + out[0]);
        }
        if (-2147483649L == out[1]) {
            throw new Exception("LHS: out[1] is " + out[1]);
        }
        if (Long.MAX_VALUE == out[2]) {
            throw new Exception("LHS: out[2] is " + out[2]);
        }
        if (Long.MIN_VALUE == out[3]) {
            throw new Exception("LHS: out[3] is " + out[3]);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13169().cmplTest_LHS();
    }
}
