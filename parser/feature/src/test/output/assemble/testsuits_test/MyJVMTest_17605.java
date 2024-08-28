import java.lang.reflect.*;

public class MyJVMTest_17605 {

    static Object v = 7;

    void bh_s_Object_1(Object v) {
    }

    Object bh_s_Object_1_delegate(Object v) {
        bh_s_Object_1(v);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17605().bh_s_Object_1_delegate(v);
    }
}
