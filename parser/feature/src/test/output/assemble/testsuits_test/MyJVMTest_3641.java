import java.util.Arrays;

public class MyJVMTest_3641 {

    static float[] array = { Float.MAX_VALUE, 0.85250646f, 0f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0.6334666f, Float.MAX_VALUE };

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
        System.out.println(Arrays.asList(new MyJVMTest_3641().reset(array)));
    }
}
