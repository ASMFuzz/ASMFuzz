public class MyJVMTest_9054 {

    static float a = Float.MIN_VALUE;

    static float b = Float.NEGATIVE_INFINITY;

    float mul_opt_float(float a, float b) {
        return Math.max(a, b) * Math.min(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9054().mul_opt_float(a, b));
    }
}
