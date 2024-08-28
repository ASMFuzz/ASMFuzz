public class MyJVMTest_16352 {

    static float a = Float.MAX_VALUE;

    static float b = Float.MAX_VALUE;

    float test_add(float a, float b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16352().test_add(a, b));
    }
}
