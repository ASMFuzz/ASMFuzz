public class MyJVMTest_10577 {

    static float a = Float.MAX_VALUE;

    static float b = Float.MIN_VALUE;

    boolean test_isLe(float a, float b) {
        return a <= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10577().test_isLe(a, b));
    }
}
