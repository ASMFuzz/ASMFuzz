public class MyJVMTest_5534 {

    static float a = Float.NEGATIVE_INFINITY;

    static float b = Float.MIN_VALUE;

    boolean test_isEq(float a, float b) {
        return a == b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5534().test_isEq(a, b));
    }
}
