public class MyJVMTest_3734 {

    static float[] a = { Float.NaN, 0f, 0f, Float.MIN_VALUE, 0.8297325f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f, Float.NaN, 0f };

    int checkSum(float[] a) {
        int sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += a[j] % (j + 1);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3734().checkSum(a));
    }
}
