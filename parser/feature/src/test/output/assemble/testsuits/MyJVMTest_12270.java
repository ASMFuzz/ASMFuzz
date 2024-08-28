public class MyJVMTest_12270 {

    static int a = 9;

    static int b = 4;

    int test_shl(int a, int b) {
        return a << b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12270().test_shl(a, b));
    }
}
