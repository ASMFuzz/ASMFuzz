public class MyJVMTest_5411 {

    static int count = 0;

    static float[] f = new float[16];

    static double[] d = new double[16];

    int doubleLoop(int count) {
        for (int i = 0; i < count; i++) {
            d[i] = -0.0d;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5411().doubleLoop(count);
    }
}
