public class MyJVMTest_8851 {

    static long a = -9223372036854775808L;

    static long b = 8723196942681260378L;

    static long c = 1875377880275315412L;

    long test(long a, long b, long c) {
        return a * c - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8851().test(a, b, c));
    }
}
