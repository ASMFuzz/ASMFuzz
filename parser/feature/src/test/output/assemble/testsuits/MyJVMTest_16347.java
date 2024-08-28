public class MyJVMTest_16347 {

    static int a = 9;

    int test_xorc2(int a) {
        return a ^ 0x123456d5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16347().test_xorc2(a));
    }
}
