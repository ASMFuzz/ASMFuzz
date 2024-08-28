import java.io.*;
import java.util.*;
import java.util.jar.*;

public class MyJVMTest_5109 {

    static String e = "e$M|C$>V%~";

    String getPathForDirEntry(String e) {
        return e.replace(".", File.separator) + ".java";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5109().getPathForDirEntry(e));
    }
}
