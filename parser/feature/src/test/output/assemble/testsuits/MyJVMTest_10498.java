public class MyJVMTest_10498 {

    static int v = 8;

    static int min = 0;

    static int max = -542886319;

    void perturb() {
        v = v + 1;
        if (v > max) {
            v = min;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10498().perturb();
    }
}
