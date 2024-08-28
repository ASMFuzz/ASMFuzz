public class MyJVMTest_8810 {

    static float[] array = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, 0.0291937f, 0f, Float.NEGATIVE_INFINITY };

    float[] increment(float[] array) {
        for (long l = 0; l < 10_000; l++) {
            for (int i = 0; i < array.length; ++i) {
                array[i] += 1;
            }
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8810().increment(array);
    }
}
