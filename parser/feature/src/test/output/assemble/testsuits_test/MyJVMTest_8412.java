public class MyJVMTest_8412 {

    short remi_sumb2_cond() {
        Short j1 = Short.valueOf((short) 1);
        Short j2 = Short.valueOf((short) 1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = (short) (j1 + 1);
            } else {
                j2 = (short) (j2 + 2);
            }
        }
        return (short) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8412().remi_sumb2_cond());
    }
}
