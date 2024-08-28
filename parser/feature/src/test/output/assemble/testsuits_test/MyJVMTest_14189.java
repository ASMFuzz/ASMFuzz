public class MyJVMTest_14189 {

    static int[] a = { -1995050411, 6, -1144985303, 4, 7, -1058504370, 0, 6, 106702847, 5 };

    static float[] b = { Float.MAX_VALUE, Float.MIN_VALUE, 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0.5138536f, 0f, 0.9091264f, Float.MIN_VALUE, 0f };

    static int c = 212422428;

    static float d = Float.POSITIVE_INFINITY;

    int[] test_vi(int[] a, float[] b, int c, float d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14189().test_vi(a, b, c, d);
    }
}
