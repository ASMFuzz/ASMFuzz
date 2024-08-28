public class MyJVMTest_8387 {

    static Double j = 0d;

    double remi_sump(Double j) {
        for (int i = 0; i < 1000; i++) {
            j = new Double(j + 1.);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8387().remi_sump(j));
    }
}
