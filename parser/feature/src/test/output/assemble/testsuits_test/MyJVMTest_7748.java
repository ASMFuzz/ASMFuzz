public class MyJVMTest_7748 {

    static double x = Double.NaN;

    static double D = -7.05306122448979611050e-01;

    static double E = 1.41428571428571436819e+00;

    static double F = 1.60714285714285720630e+00;

    int __LO(double x) {
        long transducer = Double.doubleToRawLongBits(x);
        return (int) transducer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7748().__LO(x));
    }
}
