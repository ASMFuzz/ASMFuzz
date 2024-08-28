public class MyJVMTest_11061 {

    static long[] a = { 0, -3462026951381357188L, 5010469155490889265L, 0, 9223372036854775807L, 0, 9223372036854775807L, 0, -9223372036854775808L, 9223372036854775807L };

    static Long result = 9223372036854775807L;

    long sump(long[] a, Long result) {
        for (Long i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11061().sump(a, result));
    }
}
