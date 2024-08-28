public class MyJVMTest_13312 {

    static int a = 7;

    static int b = 1;

    static int nonStaticPublicField = 0;

    int addProtectedStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13312().addProtectedStatic(a, b));
    }
}
