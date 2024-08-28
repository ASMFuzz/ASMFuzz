public class MyJVMTest_2936 {

    static byte[] barray1 = { -43, 110, -57, 63, 11, 35, 65, 20, -29, 52 };

    static byte[] barray2 = { 87, -117, -121, -54, 72, 102, 6, -19, 3, -99 };

    static byte[] barray3 = { 59, 1, 108, -18, 58, -88, -82, -108, -78, 77 };

    static long[] larray = { 0, 0, 0, 9223372036854775807L, -8789071769406339130L, -9223372036854775808L, 0, -8785261189707529302L, -2773920815430322919L, 7848249211298600599L };

    static long v = -524955629997269230L;

    long[] test1(byte[] barray1, byte[] barray2, byte[] barray3, long[] larray, long v) {
        for (int i = 0; i < larray.length; i++) {
            larray[i] = v;
        }
        for (int i = 0; i < barray3.length; i++) {
            barray3[i] = (byte) (barray1[i] + barray2[i]);
        }
        return larray;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2936().test1(barray1, barray2, barray3, larray, v);
    }
}
