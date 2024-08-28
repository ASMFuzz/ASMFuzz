public class MyJVMTest_14967 {

    static float a = Float.POSITIVE_INFINITY;

    static float b = Float.NEGATIVE_INFINITY;

    boolean test_isEq(float a, float b) {
        return a == b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14967().test_isEq(a, b));
    }
}
