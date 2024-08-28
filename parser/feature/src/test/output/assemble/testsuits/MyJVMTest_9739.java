public class MyJVMTest_9739 {

    static float a = Float.NaN;

    static float b = Float.MIN_VALUE;

    float test_mul(float a, float b) {
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9739().test_mul(a, b));
    }
}
