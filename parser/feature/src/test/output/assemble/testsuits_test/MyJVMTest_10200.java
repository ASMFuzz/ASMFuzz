public class MyJVMTest_10200 {

    int remi_sumb2_cond() {
        Integer j1 = Integer.valueOf(1);
        Integer j2 = Integer.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = j1 + 1;
            } else {
                j2 = j2 + 2;
            }
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10200().remi_sumb2_cond());
    }
}
