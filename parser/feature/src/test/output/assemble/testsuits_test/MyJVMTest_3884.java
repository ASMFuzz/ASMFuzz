public class MyJVMTest_3884 {

    static long a = -2946235748372062063L;

    long test_shlc1(long a) {
        return a << 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3884().test_shlc1(a));
    }
}
