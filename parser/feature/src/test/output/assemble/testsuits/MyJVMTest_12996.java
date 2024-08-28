public class MyJVMTest_12996 {

    static int a = 0;

    static int b = 4;

    int test_divi(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12996().test_divi(a, b));
    }
}
