public class MyJVMTest_8011 {

    double remi_sumb_cond() {
        Double j = Double.valueOf(1.);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + 1.;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8011().remi_sumb_cond());
    }
}
