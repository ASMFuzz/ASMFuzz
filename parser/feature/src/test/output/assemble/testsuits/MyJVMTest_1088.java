public class MyJVMTest_1088 {

    static Short ibc = new Short((short) 1);

    short remi_sumc2_cond() {
        Short j1 = ibc;
        Short j2 = Short.valueOf((short) 1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = (short) (j1 + ibc);
            } else {
                j2 = (short) (j2 + 2);
            }
        }
        return (short) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1088().remi_sumc2_cond());
    }
}
