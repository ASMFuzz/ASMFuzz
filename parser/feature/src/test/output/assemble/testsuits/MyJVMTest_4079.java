public class MyJVMTest_4079 {

    static Float j = Float.NEGATIVE_INFINITY;

    float remi_sump_cond(Float j) {
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + 1.f;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4079().remi_sump_cond(j));
    }
}
