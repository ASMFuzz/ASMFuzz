public class MyJVMTest_16604 {

    static float a = Float.MIN_VALUE;

    boolean test_isNeC(float a) {
        return a != 7F;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16604().test_isNeC(a));
    }
}
