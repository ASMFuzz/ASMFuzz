import java.io.*;
import java.util.*;
import java.util.jar.*;

public class MyJVMTest_9869 {

    static String e = "DSb*/T=hrH";

    String getPathForZipEntry(String e) {
        return e.replace(".", "/") + ".java";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9869().getPathForZipEntry(e));
    }
}
