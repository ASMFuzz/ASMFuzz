public class MyJVMTest_6842 {

    static int a = 1;

    int test_xorc2(int a) {
        return a ^ 0x123456d5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6842().test_xorc2(a));
    }
}
