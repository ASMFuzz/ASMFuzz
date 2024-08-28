public class MyJVMTest_8189 {

    static double i = Double.NaN;

    double simpleb2(double i) {
        Double ib1 = Double.valueOf(i);
        Double ib2 = Double.valueOf(i + 1.);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8189().simpleb2(i));
    }
}
