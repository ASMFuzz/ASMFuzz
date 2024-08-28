public class MyJVMTest_7237 {

    static float a = 0.92201626f;

    static float b = Float.MIN_VALUE;

    float max_opt_float(float a, float b) {
        return Math.max(Math.max(a, b), Math.min(a, b));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7237().max_opt_float(a, b));
    }
}
