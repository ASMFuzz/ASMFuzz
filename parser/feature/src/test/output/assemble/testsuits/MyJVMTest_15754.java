public class MyJVMTest_15754 {

    static int[] iArr = { 0, 0, -733026667, 0, 6, 0, 0, 0, 0, 3 };

    static long[] lArr = { -9223372036854775808L, 0, -9223372036854775808L, 5988275987887953920L, 9223372036854775807L, 0, 0, 9223372036854775807L, -9223372036854775808L, 0 };

    long[] test2(int[] iArr, long[] lArr) {
        for (int i = 0; i < lArr.length; i++) {
            iArr[i] = 1;
            lArr[i] = 1;
        }
        return lArr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15754().test2(iArr, lArr);
    }
}
