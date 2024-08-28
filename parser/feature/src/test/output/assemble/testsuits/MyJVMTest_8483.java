public class MyJVMTest_8483 {

    static float a = Float.MAX_VALUE;

    static float b = Float.NEGATIVE_INFINITY;

    float test_div(float a, float b) {
        return a / b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8483().test_div(a, b));
    }
}
