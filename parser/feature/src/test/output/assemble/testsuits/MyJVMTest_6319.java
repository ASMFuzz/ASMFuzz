public class MyJVMTest_6319 {

    static long a = 9223372036854775807L;

    static long b = 0;

    static long c = 9223372036854775807L;

    long test(long a, long b, long c) {
        return a * b + c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6319().test(a, b, c));
    }
}
