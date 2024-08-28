public class MyJVMTest_8652 {

    static long a = 9223372036854775807L;

    static long b = 0;

    static long c = 7754898478875272300L;

    long test(long a, long b, long c) {
        return a * c + b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8652().test(a, b, c));
    }
}
