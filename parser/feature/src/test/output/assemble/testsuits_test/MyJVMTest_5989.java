public class MyJVMTest_5989 {

    static int count = 0;

    static float[] f = new float[16];

    static double[] d = new double[16];

    int floatLoop(int count) {
        for (int i = 0; i < count; i++) {
            f[i] = -0.0f;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5989().floatLoop(count);
    }
}
