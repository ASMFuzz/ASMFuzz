import javax.management.*;
import javax.management.modelmbean.*;

public class MyJVMTest_13285 {

    static String opName = "h>!y#+ij[X";

    static Object[] opArgs = { 4, 6, 2, 8, 0, 3, 0, 5, 3, 0 };

    static String[] sig = { ">lg1Zv0{#4", "q5:xMh$L=C", "d*d;]UUX`>", ",M^;kdc*zU", "VJbQNnk`#?", "-gY4hM'A|$", "rr5M*Au0,;", "&>~uL\\:}e,", "n^kz68CC t", "}0ywCjjkt*" };

    static boolean noddyCalled = true;

    static ModelMBeanInfo mmbInfo = null;

    Object invoke(String opName, Object[] opArgs, String[] sig) throws MBeanException, ReflectionException {
        if (opName.equals("noddy")) {
            noddyCalled = true;
            return null;
        } else
            throw new IllegalArgumentException("Not noddy: " + opName);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13285().invoke(opName, opArgs, sig));
    }
}
