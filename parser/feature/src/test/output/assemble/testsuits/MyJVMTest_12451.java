public class MyJVMTest_12451 {

    static double v = Double.MAX_VALUE;

    void perturb() {
        v = v + 1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12451().perturb();
    }
}
