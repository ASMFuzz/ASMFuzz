public class MyJVMTest_15444 {

    static int count = -1110468751;

    static float[] f = new float[16];

    static double[] d = new double[16];

    int floatLoop(int count) {
        for (int i = 0; i < count; i++) {
            f[i] = -0.0f;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15444().floatLoop(count);
    }
}
