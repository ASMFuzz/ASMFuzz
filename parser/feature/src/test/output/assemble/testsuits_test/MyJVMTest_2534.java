public class MyJVMTest_2534 {

    static int a = 5;

    static int b = 6;

    static int nonStaticPublicField = 2;

    static int nonStaticFinalPublicField = 1355255160;

    int addPublicInner_Level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2534().addPublicInner_Level2(a, b));
    }
}
