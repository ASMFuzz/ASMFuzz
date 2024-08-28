public class MyJVMTest_5883 {

    float remi_sum_cond() {
        Float j = new Float(1.f);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = new Float(j + 1.f);
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5883().remi_sum_cond());
    }
}
