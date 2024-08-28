public class MyJVMTest_15548 {

    static int a = 5;

    static int b = 8;

    static int c = 2;

    int test(int a, int b, int c) {
        return a * b - a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15548().test(a, b, c));
    }
}
