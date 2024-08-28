public class MyJVMTest_17969 {

    static Double j = 0.7808745479743913;

    double remi_sump(Double j) {
        for (int i = 0; i < 1000; i++) {
            j = new Double(j + 1.);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17969().remi_sump(j));
    }
}
