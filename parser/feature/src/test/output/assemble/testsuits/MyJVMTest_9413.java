public class MyJVMTest_9413 {

    short remi_sum_cond() {
        Short j = new Short((short) 1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = new Short((short) (j + 1));
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9413().remi_sum_cond());
    }
}
