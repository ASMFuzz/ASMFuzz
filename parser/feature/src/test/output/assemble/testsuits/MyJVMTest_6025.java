import java.lang.reflect.*;

public class MyJVMTest_6025 {

    static byte v = 0;

    byte bh_sr_byte(byte v) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6025().bh_sr_byte(v));
    }
}
