public class MyJVMTest_2943 {

    double remi_sumb2() {
        Double j1 = Double.valueOf(1.);
        Double j2 = Double.valueOf(1.);
        for (int i = 0; i < 1000; i++) {
            j1 = j1 + 1.;
            j2 = j2 + 2.;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2943().remi_sumb2());
    }
}
