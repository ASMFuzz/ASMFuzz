public class MyJVMTest_6599 {

    static float a = Float.NEGATIVE_INFINITY;

    static float b = Float.NaN;

    boolean test_isGt(float a, float b) {
        return a > b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6599().test_isGt(a, b));
    }
}
