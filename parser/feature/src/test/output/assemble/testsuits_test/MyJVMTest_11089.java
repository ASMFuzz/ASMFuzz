public class MyJVMTest_11089 {

    static int a = 0;

    int test_shlc33(int a) {
        return a << 33;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11089().test_shlc33(a));
    }
}
