public class MyJVMTest_11322 {

    static long a = 0;

    static long b = -9223372036854775808L;

    long unchecked(long a, long b) {
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11322().unchecked(a, b));
    }
}
