import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_2640 {

    static Class<?> ret = null;

    static Class<?> params = null;

    MethodType mt(Class<?> ret, Class<?>... params) {
        return MethodType.methodType(ret, params);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2640().mt(ret, params));
    }
}
