public class MyJVMTest_2058 {

    static int[] a = { 2, 0, 7, -929806486, 4, 1330938227, 4, 2, 0, 0 };

    static int[] b = { 2, 8, 1, 9, 3, 5, 0, 0, 1807337049, 0 };

    static int[] c = { 0, 43765165, 7, 635482354, 6, 1531283377, 5, 5, 6, 0 };

    int[] sumReductionInit(int[] a, int[] b, int[] c) {
        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = i * 1 + j;
                b[i] = i * 1 - j;
                c[i] = i + j;
            }
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2058().sumReductionInit(a, b, c);
    }
}
