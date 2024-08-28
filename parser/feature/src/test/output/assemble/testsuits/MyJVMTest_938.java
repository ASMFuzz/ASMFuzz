public class MyJVMTest_938 {

    static Float ibc = new Float(1.f);

    float remi_sumc2_cond() {
        Float j1 = ibc;
        Float j2 = Float.valueOf(1.f);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = j1 + ibc;
            } else {
                j2 = j2 + 2;
            }
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_938().remi_sumc2_cond());
    }
}
