public class MyJVMTest_6333 {

    static double i = 0d;

    Double foob(double i) {
        return Double.valueOf(i);
    }

    double simplef(double i) {
        Double ib = foob(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6333().simplef(i));
    }
}
