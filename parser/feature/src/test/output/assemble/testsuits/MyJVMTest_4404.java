public class MyJVMTest_4404 {

    static float a = Float.POSITIVE_INFINITY;

    static float b = Float.NEGATIVE_INFINITY;

    float test_sub(float a, float b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4404().test_sub(a, b));
    }
}
