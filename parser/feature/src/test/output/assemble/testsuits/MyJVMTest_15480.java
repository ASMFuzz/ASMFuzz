import java.lang.reflect.*;

public class MyJVMTest_15480 {

    static byte v = 127;

    byte bh_sr_byte(byte v) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15480().bh_sr_byte(v));
    }
}
