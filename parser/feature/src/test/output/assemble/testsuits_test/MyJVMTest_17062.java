public class MyJVMTest_17062 {

    static float[] a = { Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, 0f, Float.NaN, Float.MIN_VALUE, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static int i = 0;

    static int j = -308287781;

    static int myKey = 920191885;

    static int myValue = 9;

    static long mySeed = 8131559560899673769L;

    float[] swap(float[] a, int i, int j) {
        float t = a[i];
        a[i] = a[j];
        a[j] = t;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17062().swap(a, i, j);
    }
}
