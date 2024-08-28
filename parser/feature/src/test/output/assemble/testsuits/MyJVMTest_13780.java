public class MyJVMTest_13780 {

    static float a = 0.6417424f;

    static float b = Float.NEGATIVE_INFINITY;

    float test_sub(float a, float b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13780().test_sub(a, b));
    }
}
