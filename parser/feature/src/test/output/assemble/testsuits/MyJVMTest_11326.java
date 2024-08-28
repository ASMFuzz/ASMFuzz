public class MyJVMTest_11326 {

    static long a = 0;

    static long b = 9223372036854775807L;

    static long c = -9223372036854775808L;

    long test(long a, long b, long c) {
        return a * b + b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11326().test(a, b, c));
    }
}
