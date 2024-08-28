import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_5860 {

    static String name = ":YCCD-}x5t";

    static String singleClassName = "AqoFDTfa^@";

    static Class singleClass = null;

    Class findClass(String name) throws ClassNotFoundException {
        if (name.equals(singleClassName))
            return singleClass;
        else
            throw new ClassNotFoundException(name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5860().findClass(name));
    }
}
