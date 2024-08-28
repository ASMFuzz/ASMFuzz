public class MyJVMTest_1110 {

    static Double j = Double.NaN;

    double remi_sump_cond(Double j) {
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + 1.;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1110().remi_sump_cond(j));
    }
}
