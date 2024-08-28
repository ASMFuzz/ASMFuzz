public class MyJVMTest_17211 {

    static int a = 6;

    static int b = 9;

    static int nonStaticPublicField = 1808060513;

    static int nonStaticFinalPublicField = -1065360237;

    int addProtectedInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17211().addProtectedInner(a, b));
    }
}
