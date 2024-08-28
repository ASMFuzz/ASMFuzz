public class MyJVMTest_5686 {

    void test1_ror(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateRight(a1[i], SHIFT_GT_IMM8));
        }
    }

    void test1_rol(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateLeft(a1[i], SHIFT_GT_IMM8));
        }
    }

    void test2_ror(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateRight(a1[i], SHIFT_LT_IMM8));
        }
    }

    void test2_rol(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateLeft(a1[i], SHIFT_LT_IMM8));
        }
    }

    void test3_ror(long[] a0, long[] a1, int shift) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateRight(a1[i], shift));
        }
    }

    void test3_rol(long[] a0, long[] a1, int shift) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateLeft(a1[i], shift));
        }
    }

    void test_rolc(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateLeft(a1[i], VALUE));
        }
    }

    void test_rolv(long[] a0, long[] a1, int shift) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateLeft(a1[i], shift));
        }
    }

    void test_rorc(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateRight(a1[i], VALUE));
        }
    }

    void test_rorv(long[] a0, long[] a1, int shift) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateRight(a1[i], shift));
        }
    }

    void test_rolc_n(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateLeft(a1[i], (-VALUE)));
        }
    }

    void test_rorc_n(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateRight(a1[i], (-VALUE)));
        }
    }

    void test_rolc_o(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateLeft(a1[i], SHIFT));
        }
    }

    void test_rorc_o(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateRight(a1[i], SHIFT));
        }
    }

    void test_rolc_on(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateLeft(a1[i], (-SHIFT)));
        }
    }

    void test_rorc_on(long[] a0, long[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (Long.rotateRight(a1[i], (-SHIFT)));
        }
    }

    static int ARRLEN = 997;

    static int ITERS = 11000;

    static long ADD_INIT = Long.MAX_VALUE - 500;

    static int VALUE = 31;

    static int SHIFT = 64;

    static int SHIFT_LT_IMM8 = -128;

    static int SHIFT_GT_IMM8 = 128;

    static long[] a0 = new long[ARRLEN];

    static long[] a1 = new long[ARRLEN];

    void test() {
        for (int i = 0; i < ARRLEN; i++) {
            long val = (long) (ADD_INIT + i);
            a1[i] = val;
        }
        System.out.println("Warmup");
        for (int i = 0; i < ITERS; i++) {
            test1_ror(a0, a1);
            test1_rol(a0, a1);
            test2_ror(a0, a1);
            test2_rol(a0, a1);
            test3_ror(a0, a1, SHIFT);
            test3_rol(a0, a1, SHIFT);
            test_rolc(a0, a1);
            test_rolv(a0, a1, VALUE);
            test_rorc(a0, a1);
            test_rorv(a0, a1, VALUE);
            test_rolc_n(a0, a1);
            test_rolv(a0, a1, -VALUE);
            test_rorc_n(a0, a1);
            test_rorv(a0, a1, -VALUE);
            test_rolc_o(a0, a1);
            test_rolv(a0, a1, SHIFT);
            test_rorc_o(a0, a1);
            test_rorv(a0, a1, SHIFT);
            test_rolc_on(a0, a1);
            test_rolv(a0, a1, -SHIFT);
            test_rorc_on(a0, a1);
            test_rorv(a0, a1, -SHIFT);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5686().test();
    }
}
