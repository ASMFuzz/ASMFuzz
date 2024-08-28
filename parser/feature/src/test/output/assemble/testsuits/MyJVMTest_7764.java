public class MyJVMTest_7764 {

    static float a = Float.MIN_VALUE;

    boolean test_isEqC(float a) {
        return a == 7F;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7764().test_isEqC(a));
    }
}
