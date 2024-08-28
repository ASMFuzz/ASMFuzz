public class MyJVMTest_3106 {

    static long a = -6051455240655654880L;

    static long b = -9223372036854775808L;

    static long c = 8611545338885572787L;

    long test(long a, long b, long c) {
        return a * b - a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3106().test(a, b, c));
    }
}
