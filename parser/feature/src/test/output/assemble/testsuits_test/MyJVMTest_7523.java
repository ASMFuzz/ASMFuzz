public class MyJVMTest_7523 {

    static float[] a = { Float.MAX_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f, 0f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.40569037f };

    static int i = 1513511833;

    static int j = 0;

    static int myKey = 2;

    static int myValue = 6;

    static long mySeed = -4181715284237219746L;

    float[] swap(float[] a, int i, int j) {
        float t = a[i];
        a[i] = a[j];
        a[j] = t;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7523().swap(a, i, j);
    }
}
