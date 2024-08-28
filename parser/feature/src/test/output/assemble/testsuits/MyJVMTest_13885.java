public class MyJVMTest_13885 {

    double remi_sum_cond() {
        Double j = new Double(1.);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = new Double(j + 1.);
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13885().remi_sum_cond());
    }
}
