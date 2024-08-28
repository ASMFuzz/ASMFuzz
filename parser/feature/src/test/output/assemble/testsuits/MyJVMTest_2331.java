public class MyJVMTest_2331 {

    static float v = Float.NaN;

    void perturb() {
        v = v + 1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2331().perturb();
    }
}
