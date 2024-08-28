public class MyJVMTest_10464 {

    double remi_sum2_cond() {
        Double j1 = new Double(1.);
        Double j2 = new Double(1.);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = new Double(j1 + 1.);
            } else {
                j2 = new Double(j2 + 2.);
            }
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10464().remi_sum2_cond());
    }
}
