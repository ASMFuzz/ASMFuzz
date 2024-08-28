public class MyJVMTest_7594 {

    static long[] a = { 0, 0, -9223372036854775808L, 9223372036854775807L, -7799437867764208023L, -9028486894209236828L, -5417451328769600108L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L };

    static long[] b = { -8962402394350377664L, -9223372036854775808L, 0, 9223372036854775807L, -8897551732113550722L, 0, 0, 0, -9223372036854775808L, 9223372036854775807L };

    static int SCALE = 2;

    long[] test_2ci_scl(long[] a, long[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
            b[i * SCALE] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7594().test_2ci_scl(a, b);
    }
}
