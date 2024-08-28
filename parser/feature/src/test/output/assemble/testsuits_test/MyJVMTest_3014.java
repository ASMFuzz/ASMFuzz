public class MyJVMTest_3014 {

    static int a = 0;

    static int b = 0;

    static int nonStaticPublicField = 992845381;

    static int nonStaticFinalPublicField = -695946199;

    int addPrivateStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3014().addPrivateStatic(a, b));
    }
}
