public class MyJVMTest_6491 {

    static int[] a0 = { 615814521, 0, 8, 8, 0, 0, -1188587497, 0, 8, 3 };

    static int[] a1 = { 0, 0, 9, 871628352, 4, 5, 0, -816772512, -1513295961, 1237282640 };

    static int BIT_MASK = 0xEC80F731;

    int[] test_andc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] & BIT_MASK);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6491().test_andc(a0, a1);
    }
}
