public class MyJVMTest_2057 {

    static float a = Float.MIN_VALUE;

    static float b = 0.9195361f;

    float mul_opt_float(float a, float b) {
        return Math.max(a, b) * Math.min(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2057().mul_opt_float(a, b));
    }
}
