public class MyJVMTest_12392 {

    static double i = Double.MIN_VALUE;

    double simple(double i) {
        Double ib = new Double(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12392().simple(i));
    }
}
