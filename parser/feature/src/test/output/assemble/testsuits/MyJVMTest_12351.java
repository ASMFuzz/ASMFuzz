public class MyJVMTest_12351 {

    static int a = 5;

    static int b = 0;

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 6;

    int addPublicInner(int a, int b) {
        return a + b + 20;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12351().addPublicInner(a, b));
    }
}
