public class MyJVMTest_11405 {

    static double i = Double.POSITIVE_INFINITY;

    double simple2(double i) {
        Double ib1 = new Double(i);
        Double ib2 = new Double(i + 1.);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11405().simple2(i));
    }
}
