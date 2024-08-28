public class MyJVMTest_1220 {

    long remi_sum_cond() {
        Long j = new Long(1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = new Long(j + 1);
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1220().remi_sum_cond());
    }
}
