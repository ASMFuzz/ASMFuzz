public class MyJVMTest_14472 {

    int remi_sum2_cond() {
        Integer j1 = new Integer(1);
        Integer j2 = new Integer(1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = new Integer(j1 + 1);
            } else {
                j2 = new Integer(j2 + 2);
            }
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14472().remi_sum2_cond());
    }
}
