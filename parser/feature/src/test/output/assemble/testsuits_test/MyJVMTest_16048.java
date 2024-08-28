public class MyJVMTest_16048 {

    static long a = -9223372036854775808L;

    long test_shlc65(long a) {
        return a << 65;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16048().test_shlc65(a));
    }
}
