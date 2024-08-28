public class MyJVMTest_7121 {

    static float[] o = { 0.80962247f, Float.NaN, Float.NEGATIVE_INFINITY, 0.33814466f, 0f, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE };

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 9;

    int getLength(float[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7121().getLength(o));
    }
}
