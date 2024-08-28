public class MyJVMTest_17582 {

    static long[] a = { -9223372036854775808L, -7986705922658958444L, -9223372036854775808L, 0, 1094774676021778249L, 9223372036854775807L, 0, 9223372036854775807L, 2580652984763729378L, -4532819201592674696L };

    static Long ibc = new Long(1);

    long sumc(long[] a) {
        Long result = ibc;
        for (Long i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17582().sumc(a));
    }
}
