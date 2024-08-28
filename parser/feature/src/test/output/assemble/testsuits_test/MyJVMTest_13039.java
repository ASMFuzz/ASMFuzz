public class MyJVMTest_13039 {

    static Long ibc = new Long(1);

    long remi_sumc_cond() {
        Long j = ibc;
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + ibc;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13039().remi_sumc_cond());
    }
}
