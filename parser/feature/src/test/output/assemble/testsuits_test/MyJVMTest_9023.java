import java.lang.reflect.*;

public class MyJVMTest_9023 {

    static Object v = 0;

    void bh_s_Object_1(Object v) {
    }

    Object bh_s_Object_1_delegate(Object v) {
        bh_s_Object_1(v);
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9023().bh_s_Object_1_delegate(v);
    }
}
