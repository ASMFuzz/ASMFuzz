public class MyJVMTest_15656 {

    static int a = 0;

    static int b = 2;

    static int nonStaticPublicField = 5;

    static int nonStaticFinalPublicField = 9;

    int addPublic_Super(int a, int b) {
        return a + b + 5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15656().addPublic_Super(a, b));
    }
}
