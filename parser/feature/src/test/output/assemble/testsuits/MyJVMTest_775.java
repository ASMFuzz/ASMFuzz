public class MyJVMTest_775 {

    static float a = Float.MAX_VALUE;

    static float b = 0f;

    boolean test_isLt(float a, float b) {
        return a < b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_775().test_isLt(a, b));
    }
}
