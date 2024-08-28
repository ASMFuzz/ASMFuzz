public class MyJVMTest_6926 {

    static double x = Double.MAX_VALUE;

    static int high = 3;

    static double D = -7.05306122448979611050e-01;

    static double E = 1.41428571428571436819e+00;

    static double F = 1.60714285714285720630e+00;

    double __HI(double x, int high) {
        long transX = Double.doubleToRawLongBits(x);
        return Double.longBitsToDouble((transX & 0x0000_0000_FFFF_FFFFL) | (((long) high)) << 32);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6926().__HI(x, high));
    }
}
