public class MyJVMTest_8330 {

    static double x = Double.NaN;

    static double left = 0d;

    static double right = Double.NEGATIVE_INFINITY;

    static double area = 0d;

    double computeFunction(double x) {
        return (x * x + 1.0) * x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8330().computeFunction(x));
    }
}
