public class MyJVMTest_12109 {

    static long a = -7756183798933521404L;

    static long b = 0;

    static long c = 9223372036854775807L;

    long test(long a, long b, long c) {
        return a * b - c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12109().test(a, b, c));
    }
}
