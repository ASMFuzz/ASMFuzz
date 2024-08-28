import java.lang.annotation.*;
import java.lang.reflect.Method;

public class MyJVMTest_16825 {

    static Class enclosedClass = null;

    static String methodSig = ".&%.p~<U /";

    int examine(Class enclosedClass, String methodSig) {
        Method m = enclosedClass.getEnclosingMethod();
        if (m == null && methodSig == null)
            return 0;
        if (m != null && m.getAnnotation(MethodDescriptor.class).value().equals(methodSig))
            return 0;
        else {
            System.err.println("\nUnexpected method value; expected:\t" + methodSig + "\ngot:\t" + m);
            return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16825().examine(enclosedClass, methodSig));
    }
}
