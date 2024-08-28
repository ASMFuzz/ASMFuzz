public class MyJVMTest_16126 {

    static float a = Float.NEGATIVE_INFINITY;

    boolean test_isLtC(float a) {
        return a < 7F;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16126().test_isLtC(a));
    }
}
