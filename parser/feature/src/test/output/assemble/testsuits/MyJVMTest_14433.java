import java.lang.reflect.*;

public class MyJVMTest_14433 {

    static long v = -9223372036854775808L;

    void bh_s_long_1(long v) {
    }

    long bh_s_long_1_delegate(long v) {
        bh_s_long_1(v);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14433().bh_s_long_1_delegate(v);
    }
}
