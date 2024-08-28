import java.io.*;

public class MyJVMTest_3972 {

    static String one = ",T~cvDkaH3";

    static int two = 0;

    static float[] three = {Float.NaN,Float.MAX_VALUE,Float.NEGATIVE_INFINITY,0f,Float.POSITIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.NaN,0f,Float.NaN,Float.POSITIVE_INFINITY};

    void init() {
        one = "one";
        two = 2;
        three = new float[5];
        float f = 3.0f;
        for (int i = 0; i < 5; i++) {
            f += 0.11;
            three[i] = f;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3972().init();
    }
}
