public class MyJVMTest_1797 {

    static long[] a = { -9223372036854775808L, 0, -2767803917081723237L, 9223372036854775807L, 4438113372759949186L, 9223372036854775807L, 0, 9223372036854775807L, 3916653901577862957L, 5272991804336046359L };

    static Long result2 = -9223372036854775808L;

    long sump2(long[] a, Long result2) {
        Long result1 = 1l;
        for (Long i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1797().sump2(a, result2));
    }
}
