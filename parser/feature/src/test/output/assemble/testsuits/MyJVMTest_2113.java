public class MyJVMTest_2113 {

    static long a = -7484473871024794889L;

    static long b = -9223372036854775808L;

    boolean test_isLt(long a, long b) {
        return a < b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2113().test_isLt(a, b));
    }
}
