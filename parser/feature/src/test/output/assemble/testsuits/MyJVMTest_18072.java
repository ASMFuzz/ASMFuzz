public class MyJVMTest_18072 {

    static float a = Float.POSITIVE_INFINITY;

    static float b = Float.MIN_VALUE;

    float test_div(float a, float b) {
        return a / b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18072().test_div(a, b));
    }
}
