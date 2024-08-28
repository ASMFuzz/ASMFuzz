public class MyJVMTest_324 {

    static long a = -9223372036854775808L;

    static long b = -518971352531000458L;

    boolean test_isNe(long a, long b) {
        return a != b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_324().test_isNe(a, b));
    }
}
