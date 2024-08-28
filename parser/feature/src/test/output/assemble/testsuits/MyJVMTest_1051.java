import java.lang.annotation.*;
import java.lang.reflect.Constructor;

public class MyJVMTest_1051 {

    static Class<?> enclosedClass = null;

    static String constructorSig = "l7rfC-Kt19";

    static Class<?> localClass = null;

    static Class<?> anotherLocalClass = null;

    int examine(Class<?> enclosedClass, String constructorSig) {
        Constructor<?> c = enclosedClass.getEnclosingConstructor();
        if (c == null && constructorSig == null)
            return 0;
        if (c != null && c.getAnnotation(ConstructorDescriptor.class).value().equals(constructorSig))
            return 0;
        else {
            System.err.println("\nUnexpected constructor value; expected:\t" + constructorSig + "\ngot:\t" + c);
            return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1051().examine(enclosedClass, constructorSig));
    }
}
