public class MyJVMTest_18105 {

    static long a = -3779253042517432889L;

    static long b = 9223372036854775807L;

    long test_shl(long a, long b) {
        return a << b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18105().test_shl(a, b));
    }
}
