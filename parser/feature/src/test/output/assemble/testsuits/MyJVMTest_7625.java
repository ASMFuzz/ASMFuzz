public class MyJVMTest_7625 {

    static long a = -6511037361415738685L;

    static long b = 9223372036854775807L;

    static long c = 992850210988785196L;

    long test(long a, long b, long c) {
        return a * c - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7625().test(a, b, c));
    }
}
