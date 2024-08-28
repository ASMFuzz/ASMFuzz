public class MyJVMTest_1367 {

    static float a = 0f;

    static float b = Float.POSITIVE_INFINITY;

    boolean test_isLe(float a, float b) {
        return a <= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1367().test_isLe(a, b));
    }
}
