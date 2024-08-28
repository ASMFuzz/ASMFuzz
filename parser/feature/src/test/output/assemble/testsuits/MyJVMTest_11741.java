public class MyJVMTest_11741 {

    static int a = 2;

    static int b = 5;

    static int nonStaticPublicField = 3;

    int addProtected(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11741().addProtected(a, b));
    }
}
