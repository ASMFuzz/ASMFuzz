public class MyJVMTest_11306 {

    static int a = -850455028;

    static int b = 0;

    static int c = 0;

    int test(int a, int b, int c) {
        return a * b + b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11306().test(a, b, c));
    }
}
