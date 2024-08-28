import java.lang.reflect.*;

public class MyJVMTest_8723 {

    static byte v = 0;

    byte bh_sr_byte(byte v) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8723().bh_sr_byte(v));
    }
}
