public class MyJVMTest_11665 {

    static Short ibc = new Short((short) 1);

    short remi_sumc_cond() {
        Short j = ibc;
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = (short) (j + ibc);
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11665().remi_sumc_cond());
    }
}
