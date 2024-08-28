public class MyJVMTest_6630 {

    static float a = 0.49966753f;

    boolean test_isLtC(float a) {
        return a < 7F;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6630().test_isLtC(a));
    }
}
