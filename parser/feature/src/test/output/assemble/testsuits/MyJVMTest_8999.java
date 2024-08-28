import java.lang.reflect.*;

public class MyJVMTest_8999 {

    static float v = Float.MIN_VALUE;

    float bh_sr_float(float v) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8999().bh_sr_float(v));
    }
}
