public class MyJVMTest_6278 {

    static int[] iArr = { 0, 0, -606750549, 0, 0, 0, 9922259, 6, 4, -904351869 };

    static long[] lArr = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, -451825146864155381L, 9223372036854775807L, -3247099025955614872L, 3146145182999173412L, -4243091400440631449L, 0 };

    long[] test2(int[] iArr, long[] lArr) {
        for (int i = 0; i < lArr.length; i++) {
            iArr[i] = 1;
            lArr[i] = 1;
        }
        return lArr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6278().test2(iArr, lArr);
    }
}
