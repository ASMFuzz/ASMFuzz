public class MyJVMTest_6183 {

    static int a = 2;

    static int b = 0;

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 0;

    int addPublic_Super(int a, int b) {
        return a + b + 5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6183().addPublic_Super(a, b));
    }
}
