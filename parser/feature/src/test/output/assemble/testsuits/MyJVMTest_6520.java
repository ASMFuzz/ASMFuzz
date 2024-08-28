public class MyJVMTest_6520 {

    static float[] a = { Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.46831626f, Float.NEGATIVE_INFINITY, 0.713674f, Float.MAX_VALUE, 0f, Float.NaN };

    static int myKey = 0;

    static int myValue = 3;

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
        new MyJVMTest_6520().sortByInsertionSort(a);
    }
}
