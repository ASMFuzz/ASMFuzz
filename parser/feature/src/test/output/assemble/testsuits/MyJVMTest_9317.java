public class MyJVMTest_9317 {

    static float[][] buffer = { { Float.POSITIVE_INFINITY, 0f, Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE }, { Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0.9661487f, Float.MAX_VALUE, 0.37150884f, 0.09676832f, Float.NaN, 0f, 0f, Float.NaN } };

    static int offset = 0;

    static int len = 4;

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
        System.out.println(new MyJVMTest_9317().process(buffer, offset, len));
    }
}
