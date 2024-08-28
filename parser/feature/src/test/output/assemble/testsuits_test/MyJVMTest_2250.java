public class MyJVMTest_2250 {

    static float a = Float.MAX_VALUE;

    boolean test_isGeC(float a) {
        return a >= 7F;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2250().test_isGeC(a));
    }
}
