public class MyJVMTest_6250 {

    static int a = 1;

    static int b = 0;

    static int nonStaticPublicField = 613147065;

    static int nonStaticFinalPublicField = -1646659854;

    int addPrivateInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6250().addPrivateInner(a, b));
    }
}
