public class MyJVMTest_1901 {

    static int a = 1;

    static int b = 4;

    static int nonStaticPublicField = 9;

    static int nonStaticFinalPublicField = 6;

    int addPrivate(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1901().addPrivate(a, b));
    }
}
