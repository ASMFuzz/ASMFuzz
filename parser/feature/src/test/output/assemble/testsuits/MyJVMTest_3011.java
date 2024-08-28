public class MyJVMTest_3011 {

    static long a = -8321863592460788915L;

    static long b = 1126706918470382945L;

    long test_mul(long a, long b) {
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3011().test_mul(a, b));
    }
}
