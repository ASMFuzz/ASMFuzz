import java.util.*;

public class MyJVMTest_5491 {

    static boolean compareClasses = true;

    static boolean compareSTEs = true;

    static Class declaringClass = null;

    static String methodName = "~sE!NDJl5v";

    static String fileName = null;

    String className() {
        return declaringClass.getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5491().className());
    }
}
