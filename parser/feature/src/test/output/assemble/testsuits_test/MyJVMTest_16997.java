public class MyJVMTest_16997 {

    static float[] array = { Float.MIN_VALUE, 0.5875505f, 0.43444848f, 0f, Float.MAX_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    float[] increment(float[] array) {
        for (long l = 0; l < 10_000; l++) {
            for (int i = 0; i < array.length; ++i) {
                array[i] += 1;
            }
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16997().increment(array);
    }
}
