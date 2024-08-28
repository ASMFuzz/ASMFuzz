public class MyJVMTest_18090 {

    static double X = java.lang.Math.PI;

    static double u = 0d;

    static boolean b = false;

    double getX() {
        return 0.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18090().getX());
    }
}
