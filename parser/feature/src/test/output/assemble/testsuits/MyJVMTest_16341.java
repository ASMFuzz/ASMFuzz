public class MyJVMTest_16341 {

    void test1_ror(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateRight(a1[i], SHIFT_GT_IMM8));
        }
    }

    void test1_rol(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateLeft(a1[i], SHIFT_GT_IMM8));
        }
    }

    void test2_ror(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateRight(a1[i], SHIFT_LT_IMM8));
        }
    }

    void test2_rol(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateLeft(a1[i], SHIFT_LT_IMM8));
        }
    }

    void test3_ror(int[] a0, int[] a1, int shift) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateRight(a1[i], shift));
        }
    }

    void test3_rol(int[] a0, int[] a1, int shift) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateLeft(a1[i], shift));
        }
    }

    void test_rolc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateLeft(a1[i], VALUE));
        }
    }

    void test_rolv(int[] a0, int[] a1, int shift) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateLeft(a1[i], shift));
        }
    }

    void test_rorc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateRight(a1[i], VALUE));
        }
    }

    void test_rorv(int[] a0, int[] a1, int shift) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateRight(a1[i], shift));
        }
    }

    void test_rolc_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateLeft(a1[i], (-VALUE)));
        }
    }

    void test_rorc_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateRight(a1[i], (-VALUE)));
        }
    }

    void test_rolc_o(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateLeft(a1[i], SHIFT));
        }
    }

    void test_rorc_o(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateRight(a1[i], SHIFT));
        }
    }

    void test_rolc_on(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateLeft(a1[i], (-SHIFT)));
        }
    }

    void test_rorc_on(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (Integer.rotateRight(a1[i], (-SHIFT)));
        }
    }

    static int ARRLEN = 997;

    static int ITERS = 11000;

    static int ADD_INIT = Integer.MAX_VALUE - 500;

    static int VALUE = 15;

    static int SHIFT = 32;

    static int SHIFT_LT_IMM8 = -128;

    static int SHIFT_GT_IMM8 = 128;

    static int[] a0 = new int[ARRLEN];

    static int[] a1 = new int[ARRLEN];

    void test() {
        for (int i = 0; i < ARRLEN; i++) {
            int val = (int) (ADD_INIT + i);
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
        new MyJVMTest_16341().test();
    }
}
