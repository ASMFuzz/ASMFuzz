public class MyJVMTest_9045 {

    static float a = Float.MIN_VALUE;

    static float b = Float.NEGATIVE_INFINITY;

    float add_opt_float(float a, float b) {
        return Math.max(a, b) + Math.min(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9045().add_opt_float(a, b));
    }
}
