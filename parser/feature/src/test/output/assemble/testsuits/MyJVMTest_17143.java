public class MyJVMTest_17143 {

    static int a = 0;

    int test_xorc1(int a) {
        return a ^ 0xf0f0f0f0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17143().test_xorc1(a));
    }
}
