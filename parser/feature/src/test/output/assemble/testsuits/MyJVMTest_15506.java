public class MyJVMTest_15506 {

    static double x = Double.NaN;

    static int low = 3;

    static double D = -7.05306122448979611050e-01;

    static double E = 1.41428571428571436819e+00;

    static double F = 1.60714285714285720630e+00;

    double __LO(double x, int low) {
        long transX = Double.doubleToRawLongBits(x);
        return Double.longBitsToDouble((transX & 0xFFFF_FFFF_0000_0000L) | (low & 0x0000_0000_FFFF_FFFFL));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15506().__LO(x, low));
    }
}
