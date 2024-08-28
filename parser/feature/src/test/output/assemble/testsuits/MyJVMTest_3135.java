public class MyJVMTest_3135 {

    static double v = Double.MAX_VALUE;

    void perturb() {
        v = v + 1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3135().perturb();
    }
}
