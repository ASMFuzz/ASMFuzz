public class MyJVMTest_5220 {

    static int a = 9;

    static int b = 0;

    static int c = 0;

    int test(int a, int b, int c) {
        return a * b + c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5220().test(a, b, c));
    }
}
