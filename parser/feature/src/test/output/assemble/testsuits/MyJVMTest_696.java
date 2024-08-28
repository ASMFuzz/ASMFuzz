import java.io.*;
import java.util.*;
import java.util.jar.*;

public class MyJVMTest_696 {

    static String e = "xse5LVb.c!";

    String getPathForZipEntry(String e) {
        return e.replace(".", "/") + ".java";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_696().getPathForZipEntry(e));
    }
}
