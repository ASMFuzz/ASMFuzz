public class MyJVMTest_4240 {

    static Integer ibc = new Integer(1);

    int remi_sumc_cond() {
        Integer j = ibc;
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + ibc;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4240().remi_sumc_cond());
    }
}
