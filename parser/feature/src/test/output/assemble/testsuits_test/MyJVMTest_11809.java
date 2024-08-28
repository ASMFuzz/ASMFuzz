public class MyJVMTest_11809 {

    static int a = 564203600;

    static int b = 0;

    static int nonStaticPublicField = 2;

    static int nonStaticFinalPublicField = 8;

    int addPublicInner_Level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11809().addPublicInner_Level2(a, b));
    }
}
