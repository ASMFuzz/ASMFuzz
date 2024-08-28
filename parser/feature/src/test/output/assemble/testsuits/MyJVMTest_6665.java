public class MyJVMTest_6665 {

    static float a = Float.MAX_VALUE;

    float test_neg(float a) {
        return -a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6665().test_neg(a));
    }
}
