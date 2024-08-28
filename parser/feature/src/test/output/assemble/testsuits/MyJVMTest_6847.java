public class MyJVMTest_6847 {

    static float a = 0.7684465f;

    static float b = Float.NEGATIVE_INFINITY;

    float test_add(float a, float b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6847().test_add(a, b));
    }
}
