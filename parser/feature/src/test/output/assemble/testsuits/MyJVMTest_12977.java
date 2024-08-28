import java.util.Arrays;

public class MyJVMTest_12977 {

    static float[] array = { 0.3583696f, 0f, 0.6148284f, 0f, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NaN, Float.MIN_VALUE };

    float[] reset(float[] array) {
        if (null == array) {
            array = new float[3];
        }
        array[0] = 1.1f;
        array[1] = 2.2f;
        array[2] = 3.3f;
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12977().reset(array)));
    }
}
