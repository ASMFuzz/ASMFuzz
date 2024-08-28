public class MyJVMTest_7097 {

    static int a = 0;

    static int b = 8;

    static int nonStaticPublicField = -1099452162;

    static int nonStaticFinalPublicField = 7;

    int addProtectedStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7097().addProtectedStatic(a, b));
    }
}
