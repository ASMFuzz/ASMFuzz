public class MyJVMTest_11135 {

    static int a = 0;

    static int b = 8;

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 0;

    int addPrivate(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11135().addPrivate(a, b));
    }
}
