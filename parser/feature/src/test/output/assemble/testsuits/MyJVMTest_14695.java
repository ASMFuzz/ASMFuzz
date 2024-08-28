public class MyJVMTest_14695 {

    static int a = 767615965;

    static int b = 9;

    static int nonStaticPublicField = -1435392541;

    int addPublicStatic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14695().addPublicStatic(a, b));
    }
}
