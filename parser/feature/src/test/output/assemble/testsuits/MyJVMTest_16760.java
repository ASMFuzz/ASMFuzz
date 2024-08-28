public class MyJVMTest_16760 {

    static float a = Float.MAX_VALUE;

    static float b = Float.MIN_VALUE;

    float max_opt_float(float a, float b) {
        return Math.max(Math.max(a, b), Math.min(a, b));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16760().max_opt_float(a, b));
    }
}
