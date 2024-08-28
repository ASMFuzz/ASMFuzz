public class MyJVMTest_13684 {

    long remi_sum2_cond() {
        Long j1 = new Long(1);
        Long j2 = new Long(1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = new Long(j1 + 1);
            } else {
                j2 = new Long(j2 + 2);
            }
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13684().remi_sum2_cond());
    }
}
