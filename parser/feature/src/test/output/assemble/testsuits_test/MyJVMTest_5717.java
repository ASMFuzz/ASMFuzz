public class MyJVMTest_5717 {

    static int[] iaarg = { -1449923886, 9, 0, -1304492578, 0, -2020875128, 4, 0, 4, 2 };

    int[] test(int[] iaarg) {
        int[] iarr = new int[777];
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                int istep = 2 * j - i + 1;
                int iadj = 0;
                if (istep < 0) {
                    iadj = iarr[0 - istep] + iaarg[i - 1];
                } else {
                    iadj = iarr[istep] + iaarg[i - 1];
                }
            }
        }
        return iaarg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5717().test(iaarg);
    }
}
