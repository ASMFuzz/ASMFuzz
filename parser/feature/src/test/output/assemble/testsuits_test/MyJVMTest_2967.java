public class MyJVMTest_2967 {

    static int a = 528400364;

    static int b = -439627036;

    int test_shl(int a, int b) {
        return a << b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2967().test_shl(a, b));
    }
}
