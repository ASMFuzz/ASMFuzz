import java.lang.invoke.*;
import java.lang.reflect.*;
import java.util.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;
import static java.lang.invoke.MethodHandleInfo.*;

public class MyJVMTest_8409 {

    static Class<?> clazz = null;

    static String name = "uWYibEL@1F";

    static MethodType methodType = null;

    static Class<?> declaringClass = null;

    static int referenceKind = -1785918684;

    MethodType getterMethodType(Class<?> clazz) {
        return methodType(clazz);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8409().getterMethodType(clazz));
    }
}
