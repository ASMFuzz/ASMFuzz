public class MyJVMTest_11022 {

    static long[] a = { 9223372036854775807L, 9223372036854775807L, 0, 1224836400539290281L, 9223372036854775807L, -9223372036854775808L, -8641459443923118542L, -3522140509870169898L, 9223372036854775807L, 9223372036854775807L };

    static Long result2 = 9223372036854775807L;

    long sump2(long[] a, Long result2) {
        Long result1 = 1l;
        for (Long i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11022().sump2(a, result2));
    }
}
