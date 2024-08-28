public class MyJVMTest_17318 {

    static float a = Float.NaN;

    boolean test_isEqC(float a) {
        return a == 7F;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17318().test_isEqC(a));
    }
}
