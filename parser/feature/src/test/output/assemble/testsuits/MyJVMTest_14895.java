public class MyJVMTest_14895 {

    static long[] a = { -7026301210162276310L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, 5370529191273343103L, -9223372036854775808L, 9223372036854775807L, -1784691282284789983L, 9223372036854775807L };

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
        System.out.println(new MyJVMTest_14895().sum2(a));
    }
}
