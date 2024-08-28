public class MyJVMTest_11211 {

    short remi_sumb_cond() {
        Short j = Short.valueOf((short) 1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = (short) (j + 1);
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11211().remi_sumb_cond());
    }
}
