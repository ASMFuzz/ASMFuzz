public class MyJVMTest_16616 {

    static int a = 0;

    static int b = 1282302693;

    static int nonStaticPublicField = 7;

    static int nonStaticFinalPublicField = 5;

    int addProtectedStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16616().addProtectedStatic(a, b));
    }
}
