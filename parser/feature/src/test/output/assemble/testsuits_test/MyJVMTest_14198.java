public class MyJVMTest_14198 {

    static long a = 9223372036854775807L;

    static long b = -9223372036854775808L;

    long checkMethod(long a, long b) {
        return Math.subtractExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14198().checkMethod(a, b));
    }
}
