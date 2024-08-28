public class MyJVMTest_8910 {

    static int a = 6;

    static int b = 0;

    static int c = 8;

    int test(int a, int b, int c) {
        return a * b + c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8910().test(a, b, c));
    }
}
