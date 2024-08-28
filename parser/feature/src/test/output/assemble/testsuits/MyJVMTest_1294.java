public class MyJVMTest_1294 {

    static int v = 3;

    static int min = -2055203055;

    static int max = 7;

    void perturb() {
        v = v + 1;
        if (v > max) {
            v = min;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1294().perturb();
    }
}
