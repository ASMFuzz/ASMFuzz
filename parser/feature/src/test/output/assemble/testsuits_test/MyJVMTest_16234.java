public class MyJVMTest_16234 {

    static float a = Float.NaN;

    static float b = Float.NaN;

    float min_opt_float(float a, float b) {
        return Math.min(Math.max(a, b), Math.min(a, b));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16234().min_opt_float(a, b));
    }
}
