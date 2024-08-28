public class MyJVMTest_10703 {

    static double X = java.lang.Math.PI;

    static double u = Double.NEGATIVE_INFINITY;

    static boolean b = false;

    boolean isX() {
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10703().isX());
    }
}
