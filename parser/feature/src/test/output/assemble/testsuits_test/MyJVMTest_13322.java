import java.io.*;

public class MyJVMTest_13322 {

    static String one = "p:`.aQGQ`5";

    static int two = 0;

    static float[] three = {Float.MAX_VALUE,Float.MIN_VALUE,Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,Float.NaN,Float.MAX_VALUE,Float.NaN,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,Float.MAX_VALUE};

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
        new MyJVMTest_13322().init();
    }
}
