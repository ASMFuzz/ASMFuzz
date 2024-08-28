public class MyJVMTest_8832 {

    static long a = 6986625838923810290L;

    static long b = -9223372036854775808L;

    static long c = -8131293022090599418L;

    long test(long a, long b, long c) {
        return a * b + a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8832().test(a, b, c));
    }
}
