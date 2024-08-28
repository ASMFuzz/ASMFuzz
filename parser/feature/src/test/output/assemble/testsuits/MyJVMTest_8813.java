public class MyJVMTest_8813 {

    static long a = 2808324883347202402L;

    static long b = 0;

    static long c = -9223372036854775808L;

    long test(long a, long b, long c) {
        return a * b + c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8813().test(a, b, c));
    }
}
