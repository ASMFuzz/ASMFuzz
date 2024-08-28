public class MyJVMTest_17904 {

    static int a = 4;

    static int b = 1757123917;

    static int nonStaticPublicField = 1059500560;

    int addPrivateStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17904().addPrivateStatic(a, b));
    }
}
