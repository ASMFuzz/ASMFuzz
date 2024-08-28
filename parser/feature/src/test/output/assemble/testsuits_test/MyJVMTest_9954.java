public class MyJVMTest_9954 {

    static float a = Float.POSITIVE_INFINITY;

    static float b = Float.MIN_VALUE;

    boolean test_isLt(float a, float b) {
        return a < b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9954().test_isLt(a, b));
    }
}
