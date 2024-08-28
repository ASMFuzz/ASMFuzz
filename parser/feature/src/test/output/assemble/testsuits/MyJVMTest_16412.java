public class MyJVMTest_16412 {

    static int a = 2;

    static int b = 0;

    static int c = 0;

    int test(int a, int b, int c) {
        return a * b - c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16412().test(a, b, c));
    }
}
