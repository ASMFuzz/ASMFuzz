public class MyJVMTest_6130 {

    static Double ibc = new Double(1.);

    double remi_sumc2_cond() {
        Double j1 = ibc;
        Double j2 = Double.valueOf(1.);
        for (int i = 0; i < 1000; i++) {
            if ((i & 1) == 0) {
                j1 = j1 + ibc;
            } else {
                j2 = j2 + 2;
            }
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6130().remi_sumc2_cond());
    }
}
