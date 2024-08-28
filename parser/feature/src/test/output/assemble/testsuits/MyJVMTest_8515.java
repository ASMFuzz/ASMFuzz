public class MyJVMTest_8515 {

    static long a = -3153887464979804678L;

    static long b = 9223372036854775807L;

    long test_shl(long a, long b) {
        return a << b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8515().test_shl(a, b));
    }
}
