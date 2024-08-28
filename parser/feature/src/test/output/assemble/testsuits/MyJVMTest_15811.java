public class MyJVMTest_15811 {

    static double i = 0.3395487217058749;

    Double foob(double i) {
        return Double.valueOf(i);
    }

    double simplef(double i) {
        Double ib = foob(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15811().simplef(i));
    }
}
