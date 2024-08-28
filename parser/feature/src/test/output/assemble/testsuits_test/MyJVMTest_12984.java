import java.lang.invoke.*;
import java.lang.reflect.*;
import java.util.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;
import static java.lang.invoke.MethodHandleInfo.*;

public class MyJVMTest_12984 {

    static MethodHandle mh = null;

    static Class<?> clazz = null;

    static String name = ")LKDVsZy3X";

    static MethodType methodType = null;

    static Class<?> declaringClass = null;

    static int referenceKind = 1797274773;

    static List<MethodHandle> specialMethodHandles = new ArrayList<>();

    boolean isInvokeSpecial(MethodHandle mh) {
        return specialMethodHandles.contains(mh);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12984().isInvokeSpecial(mh));
    }
}
