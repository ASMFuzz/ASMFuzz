public class MyJVMTest_14277 {

    static int a = 3;

    static int b = 1;

    static int nonStaticPublicField = 6;

    static int nonStaticFinalPublicField = 2;

    int addPublicInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14277().addPublicInner(a, b));
    }
}
