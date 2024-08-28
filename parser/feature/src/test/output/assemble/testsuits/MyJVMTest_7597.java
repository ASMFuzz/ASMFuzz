public class MyJVMTest_7597 {

    static int a = 2;

    int test_xorc1(int a) {
        return a ^ 0xf0f0f0f0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7597().test_xorc1(a));
    }
}
