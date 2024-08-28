public class MyJVMTest_5778 {

    double remi_sum2() {
        Double j1 = new Double(1.);
        Double j2 = new Double(1.);
        for (int i = 0; i < 1000; i++) {
            j1 = new Double(j1 + 1.);
            j2 = new Double(j2 + 2.);
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5778().remi_sum2());
    }
}
