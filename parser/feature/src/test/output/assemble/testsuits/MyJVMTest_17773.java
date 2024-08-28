public class MyJVMTest_17773 {

    static Double j1 = Double.NaN;

    double remi_sump2_cond(Double j1) {
        Double j2 = Double.valueOf(1.);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = new Double(j1 + 1.);
            } else {
                j2 = j2 + 2.;
            }
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17773().remi_sump2_cond(j1));
    }
}
