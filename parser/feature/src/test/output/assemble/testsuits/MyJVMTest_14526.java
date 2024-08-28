public class MyJVMTest_14526 {

    static int a = 1;

    static int b = 0;

    static int nonStaticPublicField = 0;

    int addPublicInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14526().addPublicInner(a, b));
    }
}
