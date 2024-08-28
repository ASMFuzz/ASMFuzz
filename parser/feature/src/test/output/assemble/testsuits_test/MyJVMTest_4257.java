public class MyJVMTest_4257 {

    static int a = 7;

    static int b = 0;

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 0;

    int addProtected(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4257().addProtected(a, b));
    }
}
