public class MyJVMTest_8775 {

    static float a = Float.MIN_VALUE;

    static float b = Float.MIN_VALUE;

    float max_opt_float(float a, float b) {
        return Math.max(Math.max(a, b), Math.min(a, b));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8775().max_opt_float(a, b));
    }
}
