import java.lang.reflect.*;

public class MyJVMTest_7213 {

    static float v = 0f;

    float bh_sr_float(float v) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7213().bh_sr_float(v));
    }
}
