public class MyJVMTest_11824 {

    float remi_sumb2_cond() {
        Float j1 = Float.valueOf(1.f);
        Float j2 = Float.valueOf(1.f);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = j1 + 1.f;
            } else {
                j2 = j2 + 2.f;
            }
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11824().remi_sumb2_cond());
    }
}
