public class MyJVMTest_6283 {

    static int a = 5;

    static int b = 3;

    static int nonStaticPublicField = 4;

    static int nonStaticFinalPublicField = 9;

    int addProtectedInner_Level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6283().addProtectedInner_Level2(a, b));
    }
}
