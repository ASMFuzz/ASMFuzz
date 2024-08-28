public class MyJVMTest_8326 {

    static int a = 0;

    static int b = 5;

    static int nonStaticPublicField = 3;

    int addPrivateStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8326().addPrivateStatic(a, b));
    }
}
