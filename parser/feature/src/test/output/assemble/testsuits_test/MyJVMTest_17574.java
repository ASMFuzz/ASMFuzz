public class MyJVMTest_17574 {

    static double f = Double.NaN;

    static int i = 6;

    static Double ibc = new Double(1.);

    double testc2(double f, int i) {
        Double ib1 = ibc;
        Double ib2 = f + 1.;
        if ((i & 1) == 0) {
            ib1 = (ibc + 1.);
            ib2 = (f + 2.);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17574().testc2(f, i));
    }
}
