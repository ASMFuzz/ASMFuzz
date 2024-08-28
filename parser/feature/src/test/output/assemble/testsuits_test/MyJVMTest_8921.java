public class MyJVMTest_8921 {

    static long a = -9223372036854775808L;

    static long b = 9149042769482216046L;

    static long c = -2272316597448624159L;

    long test(long a, long b, long c) {
        return a * b - c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8921().test(a, b, c));
    }
}
