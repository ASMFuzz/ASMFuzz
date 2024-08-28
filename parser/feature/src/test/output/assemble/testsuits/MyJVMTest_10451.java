public class MyJVMTest_10451 {

    static float a = 0.11115301f;

    static float b = Float.NEGATIVE_INFINITY;

    boolean test_isNe(float a, float b) {
        return a != b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10451().test_isNe(a, b));
    }
}
