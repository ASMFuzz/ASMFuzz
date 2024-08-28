public class MyJVMTest_9707 {

    static int a = 1;

    static int b = 3;

    static int nonStaticPublicField = 0;

    int addPrivate(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9707().addPrivate(a, b));
    }
}
