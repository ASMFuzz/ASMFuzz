public class MyJVMTest_11591 {

    static float v = Float.MIN_VALUE;

    void perturb() {
        v = v + 1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11591().perturb();
    }
}
