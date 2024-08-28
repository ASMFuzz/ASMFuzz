public class MyJVMTest_7278 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.9271031f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.43990612f, Float.NaN, 0f, Float.NEGATIVE_INFINITY };

    static float value = 0.1670537f;

    static int fromIndex = 5;

    static int count = 0;

    static int myKey = 5;

    static int myValue = 6;

    static long mySeed = 0;

    int writeValue(float[] a, float value, int fromIndex, int count) {
        for (int i = fromIndex; i < fromIndex + count; i++) {
            a[i] = value;
        }
        return fromIndex;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7278().writeValue(a, value, fromIndex, count);
    }
}
