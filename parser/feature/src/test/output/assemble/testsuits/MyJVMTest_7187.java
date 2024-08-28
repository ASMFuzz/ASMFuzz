public class MyJVMTest_7187 {

    static long a = -7941847039980326251L;

    static long b = -9223372036854775808L;

    long test_or(long a, long b) {
        return a | b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7187().test_or(a, b));
    }
}
