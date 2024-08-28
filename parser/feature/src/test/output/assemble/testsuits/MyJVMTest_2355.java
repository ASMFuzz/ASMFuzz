public class MyJVMTest_2355 {

    double remi_sum() {
        Double j = new Double(1.);
        for (int i = 0; i < 1000; i++) {
            j = new Double(j + 1.);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2355().remi_sum());
    }
}
