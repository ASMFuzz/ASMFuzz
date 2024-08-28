public class MyJVMTest_9405 {

    static float a = 0.4907773f;

    static float b = Float.MAX_VALUE;

    float add_opt_float(float a, float b) {
        return Math.max(a, b) + Math.min(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9405().add_opt_float(a, b));
    }
}
