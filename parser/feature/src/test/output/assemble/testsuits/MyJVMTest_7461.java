public class MyJVMTest_7461 {

    static float[] array = { Float.NaN, 0f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0.09274882f, 0.6167455f, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE };

    float[] increment(float[] array) {
        for (long l = 0; l < 10_000; l++) {
            for (int i = 0; i < array.length; ++i) {
                array[i] += 1;
            }
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7461().increment(array);
    }
}
