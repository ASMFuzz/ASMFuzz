public class MyJVMTest_8597 {

    static int a = 1224602445;

    static int b = 6;

    static int nonStaticPublicField = 702777004;

    int addPublicInner_level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8597().addPublicInner_level2(a, b));
    }
}
