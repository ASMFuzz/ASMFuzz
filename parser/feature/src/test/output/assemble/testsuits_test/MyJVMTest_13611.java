public class MyJVMTest_13611 {

    float remi_sumb_cond() {
        Float j = Float.valueOf(1.f);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + 1.f;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13611().remi_sumb_cond());
    }
}
