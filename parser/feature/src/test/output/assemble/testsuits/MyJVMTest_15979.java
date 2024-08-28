public class MyJVMTest_15979 {

    static int[] a0 = { 4, 2, 2, -820000774, 1263220541, 4, 619167335, 3, 992919284, 8 };

    static int[] a1 = { 4, 8, 5, 771314506, 0, 0, 1203344766, 0, 0, 5 };

    static int BIT_MASK = 0xEC80F731;

    int[] test_andc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] & BIT_MASK);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15979().test_andc(a0, a1);
    }
}
