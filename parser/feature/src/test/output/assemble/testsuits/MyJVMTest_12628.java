public class MyJVMTest_12628 {

    static int a = 0;

    static int b = 0;

    static int c = -1486723998;

    int test(int a, int b, int c) {
        return a * b - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12628().test(a, b, c));
    }
}
