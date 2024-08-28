public class MyJVMTest_16641 {

    static float[] o = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.29723817f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    static int nonStaticPublicField = 5;

    static int nonStaticFinalPublicField = 0;

    int getLength(float[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16641().getLength(o));
    }
}
