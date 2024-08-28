public class MyJVMTest_1625 {

    static float[] arr = { Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, 0f, 0.095662534f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, 0f };

    static int i = 9;

    int m3(float[] arr) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1625().m3(arr));
    }
}
