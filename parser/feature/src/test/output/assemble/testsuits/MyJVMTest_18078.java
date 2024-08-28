public class MyJVMTest_18078 {

    static int a = 2;

    int test_shlc1(int a) {
        return a << 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18078().test_shlc1(a));
    }
}
