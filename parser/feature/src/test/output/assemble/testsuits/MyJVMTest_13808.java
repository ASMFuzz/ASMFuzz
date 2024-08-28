public class MyJVMTest_13808 {

    static int a = 8;

    static int b = 4;

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 0;

    int addPublic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13808().addPublic(a, b));
    }
}
