public class MyJVMTest_13807 {

    static double[] o = { 0.3126011854548685, 0.09479529619119975, Double.NaN, 0.5857105440676833, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static int nonStaticPublicField = 4;

    static int nonStaticFinalPublicField = 326103867;

    int getLength(double[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13807().getLength(o));
    }
}
