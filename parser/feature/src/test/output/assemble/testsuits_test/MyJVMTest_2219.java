public class MyJVMTest_2219 {

    static Double ibc = new Double(1.);

    double remi_sumc2() {
        Double j1 = ibc;
        Double j2 = Double.valueOf(1.);
        for (int i = 0; i < 1000; i++) {
            j1 = j1 + ibc;
            j2 = j2 + 2.;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2219().remi_sumc2());
    }
}
