public class MyJVMTest_13073 {

    static float[] a = { 0.44489926f, Float.NaN, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.52267605f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.MIN_VALUE };

    int checkSum(float[] a) {
        int sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += a[j] % (j + 1);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13073().checkSum(a));
    }
}
