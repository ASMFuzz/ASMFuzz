import java.lang.reflect.*;

public class MyJVMTest_8778 {

    static boolean v = true;

    void bh_s_boolean_1(boolean v) {
    }

    boolean bh_s_boolean_1_delegate(boolean v) {
        bh_s_boolean_1(v);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8778().bh_s_boolean_1_delegate(v);
    }
}
