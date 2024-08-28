public class MyJVMTest_15760 {

    static int a = 5;

    static int b = 4;

    static int nonStaticPublicField = 1;

    static int nonStaticFinalPublicField = 5;

    int addProtectedInner_Level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15760().addProtectedInner_Level2(a, b));
    }
}
