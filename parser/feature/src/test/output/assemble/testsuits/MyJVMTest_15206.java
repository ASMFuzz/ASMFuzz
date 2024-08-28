import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_15206 {

    static float[] a = { 0f, 0.46402234f, Float.NaN, 0f, 0f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, 0.14056051f, Float.MAX_VALUE };

    static float[] b = { 0.9584964f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY };

    float compare(float[] a, float[] b) {
        float ac_error = 0;
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            ac_error += Math.abs(a[i] - b[i]);
            counter++;
        }
        return ac_error / ((float) counter);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15206().compare(a, b));
    }
}
