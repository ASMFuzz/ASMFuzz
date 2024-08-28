public class MyJVMTest_3524 {

    static int a = 0;

    static int b = 1;

    static int nonStaticPublicField = 7;

    static int nonStaticFinalPublicField = 0;

    int addPublicStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3524().addPublicStatic(a, b));
    }
}
