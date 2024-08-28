public class MyJVMTest_16161 {

    static float a = 0f;

    float test_neg(float a) {
        return -a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16161().test_neg(a));
    }
}
