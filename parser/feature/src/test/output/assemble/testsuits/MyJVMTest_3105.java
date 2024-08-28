public class MyJVMTest_3105 {

    static long[] a = { -6584393144958494887L, -9223372036854775808L, 9223372036854775807L, 0, -9223372036854775808L, -4612712095586501332L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L };

    long sumb2(long[] a) {
        Long result1 = 1l;
        Long result2 = 1l;
        for (Long i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3105().sumb2(a));
    }
}
