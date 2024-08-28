public class MyJVMTest_5628 {

    static float[][] value = {{Float.MAX_VALUE,0.37561697f,0f,Float.POSITIVE_INFINITY,0.91410935f,Float.NaN,Float.MIN_VALUE,0.28168982f,Float.NaN,Float.NaN},{0f,0f,0f,Float.MAX_VALUE,Float.NaN,0.26302403f,Float.NaN,Float.NEGATIVE_INFINITY,0f,0.24336755f}};

    static float[][] result = {{Float.POSITIVE_INFINITY,Float.NaN,Float.NEGATIVE_INFINITY,Float.NaN,0.19440264f,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.MAX_VALUE,0f,0f},{Float.NEGATIVE_INFINITY,Float.NaN,Float.MAX_VALUE,0.08971602f,Float.NEGATIVE_INFINITY,Float.MIN_VALUE,Float.MAX_VALUE,0.51453984f,Float.NEGATIVE_INFINITY,Float.NaN}};

    static float[][] source = {{Float.NaN,Float.NaN,Float.NaN,0.9561523f,0f,Float.NEGATIVE_INFINITY,0.7896309f,Float.NaN,Float.NEGATIVE_INFINITY,Float.NaN},{Float.MAX_VALUE,Float.MAX_VALUE,Float.NaN,Float.POSITIVE_INFINITY,Float.MAX_VALUE,Float.NaN,Float.MAX_VALUE,Float.MIN_VALUE,Float.NaN,Float.POSITIVE_INFINITY}};

    static int line0 = 0;

    static int bunch = 1;

    int size() {
        return value.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5628().size());
    }
}
