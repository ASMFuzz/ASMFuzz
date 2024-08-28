public class MyJVMTest_6902 {

    static int a = 2;

    static int b = 6;

    static int c = 1318934288;

    int test(int a, int b, int c) {
        return a * b - c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6902().test(a, b, c));
    }
}
