public class MyJVMTest_6432 {

    static Short j1 = -25460;

    short remi_sump2_cond(Short j1) {
        Short j2 = Short.valueOf((short) 1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = new Short((short) (j1 + 1));
            } else {
                j2 = (short) (j2 + 2);
            }
        }
        return (short) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6432().remi_sump2_cond(j1));
    }
}
