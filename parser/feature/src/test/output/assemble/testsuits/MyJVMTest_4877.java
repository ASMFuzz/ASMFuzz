public class MyJVMTest_4877 {

    static int a = 6;

    static int b = -308544612;

    static int nonStaticPublicField = 8;

    static int nonStaticFinalPublicField = 5;

    int addPublicInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4877().addPublicInner(a, b));
    }
}
