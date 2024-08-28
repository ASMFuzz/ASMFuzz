public class MyJVMTest_4569 {

    static long a = -9223372036854775808L;

    static long b = 0;

    long test_div(long a, long b) {
        return a / b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4569().test_div(a, b));
    }
}
