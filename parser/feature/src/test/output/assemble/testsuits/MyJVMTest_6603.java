public class MyJVMTest_6603 {

    static float a = Float.MIN_VALUE;

    static float b = Float.MIN_VALUE;

    float test_rem(float a, float b) {
        return a % b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6603().test_rem(a, b));
    }
}
