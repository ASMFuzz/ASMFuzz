public class MyJVMTest_18189 {

    static int a = 7;

    static int b = 0;

    static int nonStaticPublicField = 3;

    int addPublicInner_level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18189().addPublicInner_level2(a, b));
    }
}
