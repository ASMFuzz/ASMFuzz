public class MyJVMTest_250 {

    void testRolIntZero(int val) {
        int count = 42;
        for (int i = 0; i < 4; i++) {
            if ((i % 2) == 0) {
                count = 0;
            }
        }
        int res = Integer.rotateLeft(val, count);
        if (res != val) {
            throw new RuntimeException("test_rol_int_zero failed: " + res + " != " + val);
        }
    }

    void testRorIntZero(int val) {
        int count = 42;
        for (int i = 0; i < 4; i++) {
            if ((i % 2) == 0) {
                count = 0;
            }
        }
        int res = Integer.rotateRight(val, count);
        if (res != val) {
            throw new RuntimeException("test_ror_int_zero failed: " + res + " != " + val);
        }
    }

    static int ITERS = 50000;

    static int[] INT_VALUES = { Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 1, 2, 3, 5, 8, 13 };

    void testRolrIntZeros() {
        for (int count = 0; count < ITERS; count++) {
            for (int i = 0; i < INT_VALUES.length; i++) {
                int val = INT_VALUES[i];
                testRolIntZero(val);
                testRorIntZero(val);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_250().testRolrIntZeros();
    }
}
