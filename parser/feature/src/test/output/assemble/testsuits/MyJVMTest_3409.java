public class MyJVMTest_3409 {

    static Long j = 5563186873149572424L;

    long remi_sump_cond(Long j) {
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + 1;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3409().remi_sump_cond(j));
    }
}
