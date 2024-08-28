public class MyJVMTest_168 {

    static float[][] buffer = { { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0.09426427f, 0.6598975f, Float.NEGATIVE_INFINITY, Float.NaN, 0f, 0f }, { Float.NaN, Float.NaN, 0f, Float.MIN_VALUE, 0.0082191825f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, 0f } };

    static int offset = 7;

    static int len = 0;

    static boolean active = true;

    boolean process(float[][] buffer, int offset, int len) {
        for (int i = 0; i < buffer.length; i++) {
            float[] cbuffer = buffer[i];
            for (int j = 0; j < cbuffer.length; j++) {
                cbuffer[j] = -cbuffer[j];
            }
        }
        return active;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_168().process(buffer, offset, len));
    }
}
