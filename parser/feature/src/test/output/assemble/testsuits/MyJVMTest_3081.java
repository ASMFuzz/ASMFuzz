public class MyJVMTest_3081 {

    static double i = Double.NaN;

    double simple(double i) {
        Double ib = new Double(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3081().simple(i));
    }
}
