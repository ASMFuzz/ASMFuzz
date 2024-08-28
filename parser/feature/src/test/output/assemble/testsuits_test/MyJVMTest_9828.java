public class MyJVMTest_9828 {

    static double i = 0d;

    double simplem2(double i) {
        Double ib1 = new Double(i);
        Double ib2 = Double.valueOf(i + 1.);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9828().simplem2(i));
    }
}
