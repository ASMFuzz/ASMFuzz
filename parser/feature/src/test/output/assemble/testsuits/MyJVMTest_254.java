public class MyJVMTest_254 {

    static float a = Float.NEGATIVE_INFINITY;

    static float b = Float.NEGATIVE_INFINITY;

    float add_opt_float(float a, float b) {
        return Math.max(a, b) + Math.min(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_254().add_opt_float(a, b));
    }
}
