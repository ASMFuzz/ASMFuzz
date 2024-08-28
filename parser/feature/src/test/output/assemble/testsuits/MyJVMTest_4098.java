public class MyJVMTest_4098 {

    static Double ibc = new Double(1.);

    double remi_sumc_cond() {
        Double j = ibc;
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j = j + ibc;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4098().remi_sumc_cond());
    }
}
