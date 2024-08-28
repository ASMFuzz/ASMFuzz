public class MyJVMTest_4893 {

    static byte[] a = { -10, 8, -61, -73, -30, -45, -117, -116, -14, 4 };

    static byte[] b = { -123, 119, -11, 17, 97, 35, 11, 126, -97, 116 };

    static long[] c = { 9223372036854775807L, 0, 8525209784784796987L, -2824372559394162745L, -5754617876041292286L, 0, 0, 5796019905004228026L, -7788110750746637445L, 2635648073765826251L };

    static long[] d = { -9223372036854775808L, -4152505653300268534L, 9223372036854775807L, 0, 0, 5034152976062599381L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0 };

    byte[] test_cp_oppos(byte[] a, byte[] b, long[] c, long[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4893().test_cp_oppos(a, b, c, d);
    }
}
