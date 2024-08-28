public class MyJVMTest_17643 {

    static int[] a = { 0, 9, 5, 0, 0, 4, 0, 0, 2, 0 };

    static int[] b = { 1871384598, 2, 7, 7, 0, -1263760470, 954387198, 9, 8, 2065873873 };

    static int c = 3;

    static int d = -2143619505;

    static int OFFSET = 3;

    int[] test_2vi_off(int[] a, int[] b, int c, int d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17643().test_2vi_off(a, b, c, d);
    }
}
