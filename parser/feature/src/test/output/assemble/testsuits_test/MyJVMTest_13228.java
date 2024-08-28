public class MyJVMTest_13228 {

    static long a = 0;

    long test_shlc1(long a) {
        return a << 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13228().test_shlc1(a));
    }
}
