public class MyJVMTest_3659 {

    static int a = 0;

    static int b = 850698789;

    int test_divi(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3659().test_divi(a, b));
    }
}
