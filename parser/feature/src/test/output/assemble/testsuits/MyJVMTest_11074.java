public class MyJVMTest_11074 {

    static float a = Float.MIN_VALUE;

    boolean test_isGtC(float a) {
        return a > 7F;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11074().test_isGtC(a));
    }
}
