public class MyJVMTest_12320 {

    static int a = 590417004;

    static int b = 2;

    static int nonStaticPublicField = 7;

    static int nonStaticFinalPublicField = 4;

    int addPrivateStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12320().addPrivateStatic(a, b));
    }
}
