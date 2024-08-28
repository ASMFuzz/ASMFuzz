public class MyJVMTest_8808 {

    static int a = 7;

    static int b = 2;

    static int c = 4;

    int test(int a, int b, int c) {
        return a * b - c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8808().test(a, b, c));
    }
}
