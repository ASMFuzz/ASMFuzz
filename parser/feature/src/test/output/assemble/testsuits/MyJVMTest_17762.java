public class MyJVMTest_17762 {

    static double i = Double.MIN_VALUE;

    double simpleb2(double i) {
        Double ib1 = Double.valueOf(i);
        Double ib2 = Double.valueOf(i + 1.);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17762().simpleb2(i));
    }
}
