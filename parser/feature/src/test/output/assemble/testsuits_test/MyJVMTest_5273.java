public class MyJVMTest_5273 {

    static int a = 889108914;

    static int b = 6;

    static int nonStaticPublicField = 7;

    int addPublicStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5273().addPublicStatic(a, b));
    }
}
