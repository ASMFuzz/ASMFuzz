import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.util.Arrays.*;

public class MyJVMTest_14312 {

    static Class c = null;

    int probe(Class c) {
        int errs = 0;
        try {
            c.getTypeParameters();
            c.getGenericSuperclass();
            c.getGenericInterfaces();
        } catch (Throwable t) {
            errs++;
            System.err.println(t);
        }
        Field[] fields = c.getDeclaredFields();
        if (fields != null)
            for (Field field : fields) {
                try {
                    field.getGenericType();
                } catch (Throwable t) {
                    errs++;
                    System.err.println("FIELD " + field);
                    System.err.println(t);
                }
            }
        Method[] methods = c.getDeclaredMethods();
        if (methods != null)
            for (Method method : methods) {
                try {
                    method.getTypeParameters();
                    method.getGenericReturnType();
                    method.getGenericParameterTypes();
                    method.getGenericExceptionTypes();
                } catch (Throwable t) {
                    errs++;
                    System.err.println("METHOD " + method);
                    System.err.println(t);
                }
            }
        Constructor[] ctors = c.getDeclaredConstructors();
        if (ctors != null)
            for (Constructor ctor : ctors) {
                try {
                    ctor.getTypeParameters();
                    ctor.getGenericParameterTypes();
                    ctor.getGenericExceptionTypes();
                } catch (Throwable t) {
                    errs++;
                    System.err.println("CONSTRUCTOR " + ctor);
                    System.err.println(t);
                }
            }
        return errs;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14312().probe(c));
    }
}
