public class MyJVMTest_8488 {

    static int a = 4;

    int test_shlc1(int a) {
        return a << 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8488().test_shlc1(a));
    }
}
