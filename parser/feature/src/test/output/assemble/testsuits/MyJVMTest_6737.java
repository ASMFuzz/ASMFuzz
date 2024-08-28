public class MyJVMTest_6737 {

    static float a = Float.NaN;

    static float b = 0.7584441f;

    float min_opt_float(float a, float b) {
        return Math.min(Math.max(a, b), Math.min(a, b));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6737().min_opt_float(a, b));
    }
}
