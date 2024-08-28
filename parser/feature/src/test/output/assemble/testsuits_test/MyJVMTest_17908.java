public class MyJVMTest_17908 {

    static double x = Double.POSITIVE_INFINITY;

    static double left = 0d;

    static double right = Double.POSITIVE_INFINITY;

    static double area = Double.MIN_VALUE;

    double computeFunction(double x) {
        return (x * x + 1.0) * x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17908().computeFunction(x));
    }
}
