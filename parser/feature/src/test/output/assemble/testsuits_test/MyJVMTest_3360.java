import java.util.jar.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class MyJVMTest_3360 {

    static String key = "lg6BUziIhP";

    static JarFile jarFile = null;

    static Manifest manifest = null;

    static Attributes mainAttributes = null;

    static Map map = new HashMap();

    static URLClassLoader ucl = null;

    String nameToClassName(String key) {
        String key2 = key.replace('/', File.separatorChar);
        int li = key2.lastIndexOf(".class");
        key2 = key2.substring(0, li);
        return key2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3360().nameToClassName(key));
    }
}
