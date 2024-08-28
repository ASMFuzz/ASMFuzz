import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_15307 {

    static String name = "u1Yl~j&4'\\";

    static String singleClassName = "3Ws&&Y'<9 ";

    static Class singleClass = null;

    Class findClass(String name) throws ClassNotFoundException {
        if (name.equals(singleClassName))
            return singleClass;
        else
            throw new ClassNotFoundException(name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15307().findClass(name));
    }
}
