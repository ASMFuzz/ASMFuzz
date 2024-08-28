public class MyJVMTest_10305 {

    static Double j = Double.MIN_VALUE;

    double remi_sump_cond(Double j) {
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + 1.;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10305().remi_sump_cond(j));
    }
}
