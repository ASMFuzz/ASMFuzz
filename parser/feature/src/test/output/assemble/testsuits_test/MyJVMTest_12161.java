public class MyJVMTest_12161 {

    static int mI = 0;

    static long mJ = 0;

    static float mF = 0f;

    void testMethod() {
        for (int i0 = 0; i0 < 100; i0++) {
            if (mF != 0) {
            } else {
                try {
                    mJ = Long.MAX_VALUE;
                    for (int i1 = 0; i1 < 101; i1++) {
                        for (int i2 = 0; i2 < 102; i2++) {
                            mI = new Integer(0x1234);
                        }
                    }
                } catch (Exception ignored) {
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12161().testMethod();
    }
}
