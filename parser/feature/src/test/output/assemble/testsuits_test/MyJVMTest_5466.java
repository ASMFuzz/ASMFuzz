public class MyJVMTest_5466 {

    static long[] a = { 679381158252666169L, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 0, -9223372036854775808L };

    long sum2(long[] a) {
        long result1 = 1;
        long result2 = 1;
        for (Long i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5466().sum2(a));
    }
}
