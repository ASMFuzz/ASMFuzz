public class MyJVMTest_15158 {

    static int[] iaarg = { 1276734450, 8, 5, 7, -2023226187, 4, 3, 0, 5, -1126813749 };

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
        new MyJVMTest_15158().test(iaarg);
    }
}
