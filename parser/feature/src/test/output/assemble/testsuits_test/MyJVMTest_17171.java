public class MyJVMTest_17171 {

    static long a = 9223372036854775807L;

    static long b = -9223372036854775808L;

    static long c = 8266049791034787668L;

    long test(long a, long b, long c) {
        return a * c - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17171().test(a, b, c));
    }
}
