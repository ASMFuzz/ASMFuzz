public class MyJVMTest_542 {

    static int a = 0;

    static int b = 0;

    static int nonStaticPublicField = 0;

    int addPrivate(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_542().addPrivate(a, b));
    }
}
