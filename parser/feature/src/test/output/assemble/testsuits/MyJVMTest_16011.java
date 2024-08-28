public class MyJVMTest_16011 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0.10459882f, 0f, Float.NaN, Float.MAX_VALUE };

    static int myKey = 1;

    static int myValue = 2;

    static long mySeed = -9223372036854775808L;

    float[] sortByInsertionSort(float[] a) {
        for (int j, i = 1; i < a.length; i++) {
            float ai = a[i];
            for (j = i - 1; j >= 0 && ai < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = ai;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16011().sortByInsertionSort(a);
    }
}
