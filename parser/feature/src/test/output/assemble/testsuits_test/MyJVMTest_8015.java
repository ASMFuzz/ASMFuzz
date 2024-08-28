public class MyJVMTest_8015 {

    static long[] a = { 0, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L };

    static Long ibc = new Long(1);

    long sumc(long[] a) {
        Long result = ibc;
        for (Long i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8015().sumc(a));
    }
}
