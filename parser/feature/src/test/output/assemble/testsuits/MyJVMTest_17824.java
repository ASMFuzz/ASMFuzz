public class MyJVMTest_17824 {

    static Integer j = -770520484;

    int remi_sump_cond(Integer j) {
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + 1;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17824().remi_sump_cond(j));
    }
}
