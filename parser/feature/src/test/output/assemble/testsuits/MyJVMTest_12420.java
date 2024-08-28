public class MyJVMTest_12420 {

    static long a = 9223372036854775807L;

    static long b = 0;

    static long c = -1771737613964371674L;

    long test(long a, long b, long c) {
        return a * b - a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12420().test(a, b, c));
    }
}
