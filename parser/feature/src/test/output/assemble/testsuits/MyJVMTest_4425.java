public class MyJVMTest_4425 {

    static double[] o = { 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.7902646083850324, 0.5499632279927331 };

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = -1565602620;

    int getLength(double[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4425().getLength(o));
    }
}
