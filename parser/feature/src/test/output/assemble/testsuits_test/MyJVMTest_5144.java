public class MyJVMTest_5144 {

    static Double ibc = new Double(1.);

    double remi_sumc() {
        Double j = ibc;
        for (int i = 0; i < 1000; i++) {
            j = j + ibc;
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5144().remi_sumc());
    }
}
