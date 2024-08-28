public class MyJVMTest_2080 {

    static long a = 0;

    static long b = 9223372036854775807L;

    static long c = 1959990682545582071L;

    long test(long a, long b, long c) {
        return a * b + b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2080().test(a, b, c));
    }
}
