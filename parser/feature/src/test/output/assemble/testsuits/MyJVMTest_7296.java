public class MyJVMTest_7296 {

    static double X = java.lang.Math.PI;

    static double u = Double.POSITIVE_INFINITY;

    static boolean b = false;

    double getX() {
        return X;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7296().getX());
    }
}
