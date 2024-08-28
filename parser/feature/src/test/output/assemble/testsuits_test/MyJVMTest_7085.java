public class MyJVMTest_7085 {

    static float a = Float.POSITIVE_INFINITY;

    boolean test_isNeC(float a) {
        return a != 7F;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7085().test_isNeC(a));
    }
}
