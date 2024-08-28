import java.lang.reflect.*;

public class MyJVMTest_5023 {

    static long v = 0;

    void bh_s_long_1(long v) {
    }

    long bh_s_long_1_delegate(long v) {
        bh_s_long_1(v);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5023().bh_s_long_1_delegate(v);
    }
}
