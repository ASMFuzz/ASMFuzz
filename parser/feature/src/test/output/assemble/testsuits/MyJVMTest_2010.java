public class MyJVMTest_2010 {

    static long a = 9223372036854775807L;

    static long b = 9223372036854775807L;

    long test_and(long a, long b) {
        return a & b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2010().test_and(a, b));
    }
}
