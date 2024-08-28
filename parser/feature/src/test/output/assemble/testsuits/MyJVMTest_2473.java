public class MyJVMTest_2473 {

    static int a = 0;

    static int b = 7;

    static int nonStaticPublicField = -376405370;

    int addProtected(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2473().addProtected(a, b));
    }
}
