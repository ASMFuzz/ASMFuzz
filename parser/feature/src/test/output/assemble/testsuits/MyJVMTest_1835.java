public class MyJVMTest_1835 {

    static long[] a = { -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 468734936610420727L, -1144204646810715873L, 3175301543066244280L, 0, 9223372036854775807L };

    static Long result = -9223372036854775808L;

    long sump(long[] a, Long result) {
        for (Long i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1835().sump(a, result));
    }
}
