import java.lang.invoke.*;
import java.lang.reflect.*;
import java.util.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;
import static java.lang.invoke.MethodHandleInfo.*;

public class MyJVMTest_15736 {

    static Class<?> clazz = null;

    static String name = "\\iR'w%'9F{";

    static MethodType methodType = null;

    static Class<?> declaringClass = null;

    static int referenceKind = 0;

    MethodType setterMethodType(Class<?> clazz) {
        return methodType(void.class, clazz);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15736().setterMethodType(clazz));
    }
}
