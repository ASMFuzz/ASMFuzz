public class MyJVMTest_10276 {

    static int[] pos = { 0, 1, 2, 3 };

    static int[] neg = { 0, -1, -2, -3 };

    static int[] max = { 2147483647, 2147483646, 2147483645, 2147483644 };

    static int[] min = { -2147483648, -2147483647, -2147483646, -2147483645 };

    static int[] out = { (int) 2147483648L, (int) -2147483649L, (int) Long.MAX_VALUE, (int) Long.MIN_VALUE };

    void cmplTest() throws Exception {
        if (pos[0] != 0L) {
            throw new Exception("pos[0] is " + pos[0]);
        }
        if (pos[1] != 1L) {
            throw new Exception("pos[1] is " + pos[1]);
        }
        if (pos[2] != 2L) {
            throw new Exception("pos[2] is " + pos[2]);
        }
        if (pos[3] != 3L) {
            throw new Exception("pos[3] is " + pos[3]);
        }
        if (neg[0] != -0L) {
            throw new Exception("neg[0] is " + neg[0]);
        }
        if (neg[1] != -1L) {
            throw new Exception("neg[1] is " + neg[1]);
        }
        if (neg[2] != -2L) {
            throw new Exception("neg[2] is " + neg[2]);
        }
        if (neg[3] != -3L) {
            throw new Exception("neg[3] is " + neg[3]);
        }
        if (max[0] != 2147483647L) {
            throw new Exception("max[0] is " + max[0]);
        }
        if (max[1] != 2147483646L) {
            throw new Exception("max[1] is " + max[1]);
        }
        if (max[2] != 2147483645L) {
            throw new Exception("max[2] is " + max[2]);
        }
        if (max[3] != 2147483644L) {
            throw new Exception("max[3] is " + max[3]);
        }
        if (min[0] != -2147483648L) {
            throw new Exception("min[0] is " + min[0]);
        }
        if (min[1] != -2147483647L) {
            throw new Exception("min[1] is " + min[1]);
        }
        if (min[2] != -2147483646L) {
            throw new Exception("min[2] is " + min[2]);
        }
        if (min[3] != -2147483645L) {
            throw new Exception("min[3] is " + min[3]);
        }
        if (out[0] == 2147483648L) {
            throw new Exception("out[0] is " + out[0]);
        }
        if (out[1] == -2147483649L) {
            throw new Exception("out[1] is " + out[1]);
        }
        if (out[2] == Long.MAX_VALUE) {
            throw new Exception("out[2] is " + out[2]);
        }
        if (out[3] == Long.MIN_VALUE) {
            throw new Exception("out[3] is " + out[3]);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10276().cmplTest();
    }
}
