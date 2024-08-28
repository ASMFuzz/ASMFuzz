public class MyJVMTest_15064 {

    static float[][] value = {{0f,Float.NEGATIVE_INFINITY,Float.MAX_VALUE,Float.NaN,Float.MIN_VALUE,Float.MIN_VALUE,0.104044616f,Float.NEGATIVE_INFINITY,Float.MIN_VALUE,Float.MIN_VALUE},{0.50031453f,Float.NaN,Float.MIN_VALUE,0.6926615f,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,0f,0.21686041f,Float.MAX_VALUE,Float.NaN}};

    static float[][] result = {{Float.NEGATIVE_INFINITY,0f,0f,Float.MAX_VALUE,Float.POSITIVE_INFINITY,0.76805896f,Float.POSITIVE_INFINITY,Float.MAX_VALUE,Float.MIN_VALUE,Float.MIN_VALUE},{Float.NEGATIVE_INFINITY,Float.MIN_VALUE,Float.POSITIVE_INFINITY,Float.NEGATIVE_INFINITY,0f,Float.NEGATIVE_INFINITY,Float.NaN,0.5356279f,Float.MIN_VALUE,Float.NaN}};

    static float[][] source = {{0f,Float.MIN_VALUE,Float.MIN_VALUE,Float.NaN,Float.POSITIVE_INFINITY,0.059635878f,Float.NEGATIVE_INFINITY,0.19079036f,Float.NEGATIVE_INFINITY,0f},{Float.POSITIVE_INFINITY,0.28987014f,Float.MAX_VALUE,Float.MIN_VALUE,0f,Float.MIN_VALUE,Float.POSITIVE_INFINITY,0f,Float.MIN_VALUE,Float.MAX_VALUE}};

    static int line0 = 6;

    static int bunch = -2070269846;

    int size() {
        return value.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15064().size());
    }
}
