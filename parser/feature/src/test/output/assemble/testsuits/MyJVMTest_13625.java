public class MyJVMTest_13625 {

    static int a = 0;

    static int b = 1;

    static int nonStaticPublicField = 7;

    static int nonStaticFinalPublicField = 0;

    int addProtected(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13625().addProtected(a, b));
    }
}
