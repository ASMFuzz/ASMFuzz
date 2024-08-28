public class MyJVMTest_8856 {

    static int a = 7;

    static int b = 5;

    static int c = 0;

    int test(int a, int b, int c) {
        return a * b + b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8856().test(a, b, c));
    }
}
