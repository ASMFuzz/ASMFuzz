import java.lang.reflect.*;

public class MyJVMTest_16736 {

    static float v = Float.MAX_VALUE;

    float bh_sr_float(float v) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16736().bh_sr_float(v));
    }
}
