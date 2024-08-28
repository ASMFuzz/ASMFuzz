public class MyJVMTest_12202 {

    static Long ibc = new Long(1);

    long remi_sumc2_cond() {
        Long j1 = ibc;
        Long j2 = Long.valueOf(1);
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
        System.out.println(new MyJVMTest_12202().remi_sumc2_cond());
    }
}
