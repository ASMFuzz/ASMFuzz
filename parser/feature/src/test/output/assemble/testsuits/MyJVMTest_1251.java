public class MyJVMTest_1251 {

    static float a = Float.NaN;

    static float b = Float.MIN_VALUE;

    boolean test_isNe(float a, float b) {
        return a != b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1251().test_isNe(a, b));
    }
}
