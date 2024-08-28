public class MyJVMTest_15725 {

    static int a = 8;

    static int b = 818674689;

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 8;

    int addPrivateInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15725().addPrivateInner(a, b));
    }
}
