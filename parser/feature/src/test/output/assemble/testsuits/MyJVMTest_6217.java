public class MyJVMTest_6217 {

    static int a = 2;

    static int b = 0;

    int test_and(int a, int b) {
        return a & b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6217().test_and(a, b));
    }
}
