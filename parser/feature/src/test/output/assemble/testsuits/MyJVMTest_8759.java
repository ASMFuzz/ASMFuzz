public class MyJVMTest_8759 {

    static int a = -1688874773;

    static int b = 0;

    static int c = 0;

    int test(int a, int b, int c) {
        return a * c + b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8759().test(a, b, c));
    }
}
