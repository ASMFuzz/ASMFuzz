public class MyJVMTest_16099 {

    static float a = Float.POSITIVE_INFINITY;

    static float b = Float.MAX_VALUE;

    float test_rem(float a, float b) {
        return a % b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16099().test_rem(a, b));
    }
}
