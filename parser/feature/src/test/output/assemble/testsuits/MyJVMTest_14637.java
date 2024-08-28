public class MyJVMTest_14637 {

    static int a = 0;

    static int b = 0;

    static int c = -101465346;

    int test(int a, int b, int c) {
        return a * b + c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14637().test(a, b, c));
    }
}
