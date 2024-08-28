public class MyJVMTest_12387 {

    static Integer j1 = 9;

    int remi_sump2_cond(Integer j1) {
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
        System.out.println(new MyJVMTest_12387().remi_sump2_cond(j1));
    }
}
