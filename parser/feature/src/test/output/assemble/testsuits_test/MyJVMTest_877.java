public class MyJVMTest_877 {

    int remi_sum_cond() {
        Integer j = new Integer(1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = new Integer(j + 1);
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_877().remi_sum_cond());
    }
}
