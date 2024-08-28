public class MyJVMTest_3131 {

    long remi_summ2_cond() {
        Long j1 = new Long(1);
        Long j2 = Long.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = new Long(j1 + 1);
            } else {
                j2 = j2 + 2;
            }
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3131().remi_summ2_cond());
    }
}
