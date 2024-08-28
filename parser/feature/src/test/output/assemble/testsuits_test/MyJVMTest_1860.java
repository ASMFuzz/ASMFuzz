public class MyJVMTest_1860 {

    static int a = -828609188;

    int test_shlc33(int a) {
        return a << 33;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1860().test_shlc33(a));
    }
}
