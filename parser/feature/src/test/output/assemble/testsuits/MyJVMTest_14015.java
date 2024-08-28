public class MyJVMTest_14015 {

    static Short j = 32767;

    short remi_sump_cond(Short j) {
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = (short) (j + 1);
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14015().remi_sump_cond(j));
    }
}
