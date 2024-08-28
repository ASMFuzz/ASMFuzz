public class MyJVMTest_1774 {

    float remi_sum2_cond() {
        Float j1 = new Float(1.f);
        Float j2 = new Float(1.f);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = new Float(j1 + 1.f);
            } else {
                j2 = new Float(j2 + 2.f);
            }
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1774().remi_sum2_cond());
    }
}
