public class MyJVMTest_10847 {

    static float[] arr = { Float.NaN, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.69328535f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE };

    static int i = 1;

    int m3(float[] arr) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10847().m3(arr));
    }
}
