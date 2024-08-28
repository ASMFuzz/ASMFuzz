public class MyJVMTest_8512 {

    static double i = Double.MIN_VALUE;

    static Double ibc = new Double(1.);

    double simplec2(double i) {
        Double ib1 = ibc;
        Double ib2 = Double.valueOf(i + 1.);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8512().simplec2(i));
    }
}
