public class MyJVMTest_11334 {

    void test() {
        int[] iarr1 = new int[888];
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                int istep = 2 * j - i;
                int iadj = 0;
                if (istep < 0) {
                    iadj = iarr1[-istep];
                } else {
                    iadj = iarr1[istep];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11334().test();
    }
}
