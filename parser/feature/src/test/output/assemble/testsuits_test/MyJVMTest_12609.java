public class MyJVMTest_12609 {

    static long a = 9223372036854775807L;

    static long b = 9223372036854775807L;

    long test_shr(long a, long b) {
        return a >> b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12609().test_shr(a, b));
    }
}
