import java.io.*;
import java.util.*;
import java.util.jar.*;

public class MyJVMTest_17506 {

    static String e = "NS$Rp?Xz\\b";

    String getBodyForEntry(String e) {
        int sep = e.lastIndexOf(".");
        String pkgName = e.substring(0, sep);
        String className = e.substring(sep + 1);
        return "package " + pkgName + "; public class " + className + "{ class Inner { } }";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17506().getBodyForEntry(e));
    }
}
