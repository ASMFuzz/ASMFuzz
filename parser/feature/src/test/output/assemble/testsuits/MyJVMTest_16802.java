public class MyJVMTest_16802 {

    static float[] a = { Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, 0.6415657f, 0f, 0.4916659f, 0f, Float.POSITIVE_INFINITY, Float.NaN, 0.2652908f };

    static float value = 0.77396643f;

    static int fromIndex = 9;

    static int count = 4;

    static int myKey = 8;

    static int myValue = 0;

    static long mySeed = 9223372036854775807L;

    int writeValue(float[] a, float value, int fromIndex, int count) {
        for (int i = fromIndex; i < fromIndex + count; i++) {
            a[i] = value;
        }
        return fromIndex;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16802().writeValue(a, value, fromIndex, count);
    }
}
