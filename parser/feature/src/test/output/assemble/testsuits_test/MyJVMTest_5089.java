public class MyJVMTest_5089 {

    static int a = 1;

    static int b = 3;

    int test_ushr(int a, int b) {
        return a >>> b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5089().test_ushr(a, b));
    }
}
