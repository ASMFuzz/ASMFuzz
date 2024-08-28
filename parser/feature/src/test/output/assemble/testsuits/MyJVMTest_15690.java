public class MyJVMTest_15690 {

    static int a = 340977899;

    static int b = 5;

    int test_and(int a, int b) {
        return a & b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15690().test_and(a, b));
    }
}
