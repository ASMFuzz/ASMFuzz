public class MyJVMTest_12858 {

    static int a = 3;

    static int b = 3;

    static int nonStaticPublicField = -1321700836;

    static int nonStaticFinalPublicField = 4;

    int addPublicStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12858().addPublicStatic(a, b));
    }
}
