public class MyJVMTest_12909 {

    static float a = 0.3501678f;

    static float b = Float.MIN_VALUE;

    boolean test_isGe(float a, float b) {
        return a >= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12909().test_isGe(a, b));
    }
}
