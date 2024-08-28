public class MyJVMTest_573 {

    static float a = Float.MAX_VALUE;

    static float b = Float.MIN_VALUE;

    float test_mul(float a, float b) {
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_573().test_mul(a, b));
    }
}
