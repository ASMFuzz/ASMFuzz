public class MyJVMTest_16034 {

    static Integer ibc = new Integer(1);

    int remi_sumc2_cond() {
        Integer j1 = ibc;
        Integer j2 = Integer.valueOf(1);
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
        System.out.println(new MyJVMTest_16034().remi_sumc2_cond());
    }
}
