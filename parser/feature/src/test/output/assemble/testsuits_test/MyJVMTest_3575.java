public class MyJVMTest_3575 {

    static float a = Float.NEGATIVE_INFINITY;

    static float b = Float.POSITIVE_INFINITY;

    boolean test_isGe(float a, float b) {
        return a >= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3575().test_isGe(a, b));
    }
}
