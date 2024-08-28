public class MyJVMTest_16162 {

    int remi_sumb_cond() {
        Integer j = Integer.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + 1;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16162().remi_sumb_cond());
    }
}
