public class MyJVMTest_11303 {

    static float a = Float.MIN_VALUE;

    static float b = Float.NaN;

    float mul_opt_float(float a, float b) {
        return Math.max(a, b) * Math.min(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11303().mul_opt_float(a, b));
    }
}
