public class MyJVMTest_7661 {

    static int a = -1123532681;

    static int b = 4;

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 3;

    int addProtectedInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7661().addProtectedInner(a, b));
    }
}
