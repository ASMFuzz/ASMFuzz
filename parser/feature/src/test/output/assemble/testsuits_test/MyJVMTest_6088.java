public class MyJVMTest_6088 {

    static int a = 1;

    static int b = 0;

    static int c = 0;

    int test(int a, int b, int c) {
        return a * b - a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6088().test(a, b, c));
    }
}
