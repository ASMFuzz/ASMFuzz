import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_5763 {

    static float[] a = { Float.NaN, Float.NaN, Float.MAX_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.17097354f, Float.NaN, 0.7459995f };

    static float[] b = { Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, Float.NaN, Float.MAX_VALUE, 0.25334907f, 0.16282785f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

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
        System.out.println(new MyJVMTest_5763().compare(a, b));
    }
}
