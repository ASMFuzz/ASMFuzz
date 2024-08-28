public class MyJVMTest_3962 {

    static int a = 4;

    static int b = 0;

    static int nonStaticPublicField = -226400176;

    int addProtectedStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3962().addProtectedStatic(a, b));
    }
}
