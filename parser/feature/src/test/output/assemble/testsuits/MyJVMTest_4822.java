public class MyJVMTest_4822 {

    double remi_sumb() {
        Double j = Double.valueOf(1.);
        for (int i = 0; i < 1000; i++) {
            j = j + 1.;
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4822().remi_sumb());
    }
}
