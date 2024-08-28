public class MyJVMTest_1410 {

    static Float ibc = new Float(1.f);

    float remi_sumc_cond() {
        Float j = ibc;
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + ibc;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1410().remi_sumc_cond());
    }
}
