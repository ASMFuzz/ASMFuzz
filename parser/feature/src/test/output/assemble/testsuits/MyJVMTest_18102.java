public class MyJVMTest_18102 {

    static double i = 0d;

    static Double ibc = new Double(1.);

    double simplec2(double i) {
        Double ib1 = ibc;
        Double ib2 = Double.valueOf(i + 1.);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18102().simplec2(i));
    }
}
