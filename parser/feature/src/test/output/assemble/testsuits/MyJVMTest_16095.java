public class MyJVMTest_16095 {

    static float a = Float.NEGATIVE_INFINITY;

    static float b = Float.POSITIVE_INFINITY;

    boolean test_isGt(float a, float b) {
        return a > b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16095().test_isGt(a, b));
    }
}
