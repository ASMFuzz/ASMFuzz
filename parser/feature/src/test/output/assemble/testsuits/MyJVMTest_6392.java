public class MyJVMTest_6392 {

    static double a = 0.9559231086536879;

    double test_neg(double a) {
        return -a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6392().test_neg(a));
    }
}
