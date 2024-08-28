public class MyJVMTest_5193 {

    void check(long[] a) {
        for (int j = 0; j < 20; j++) {
            if (j >= 2 && j <= 6) {
                if (a[j] != 132) {
                    throw new RuntimeException("expected 132 at index " + j + " but got " + a[j]);
                }
            } else if (a[j] != 0) {
                throw new RuntimeException("expected 0 at index " + j + " but got " + a[j]);
            }
        }
    }

    static long b = 0;

    void test() {
        long[] r = new long[20];
        for (int q = 0; q < 12; ++q) {
            for (int i = 1; i < 6; ++i) {
                r[i + 1] += b;
            }
            b += 2;
        }
        check(r);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5193().test();
    }
}
