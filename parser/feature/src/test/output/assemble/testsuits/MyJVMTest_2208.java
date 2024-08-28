public class MyJVMTest_2208 {

    static long a = -9223372036854775808L;

    static long b = -9223372036854775808L;

    static long c = 0;

    long test(long a, long b, long c) {
        return a * c + b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2208().test(a, b, c));
    }
}
