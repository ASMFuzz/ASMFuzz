public class MyJVMTest_9481 {

    static long a = 9223372036854775807L;

    static long b = -9223372036854775808L;

    boolean test_isNe(long a, long b) {
        return a != b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9481().test_isNe(a, b));
    }
}
