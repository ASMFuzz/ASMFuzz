public class MyJVMTest_4571 {

    int remi_summ2_cond() {
        Integer j1 = new Integer(1);
        Integer j2 = Integer.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = new Integer(j1 + 1);
            } else {
                j2 = j2 + 2;
            }
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4571().remi_summ2_cond());
    }
}
