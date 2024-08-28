import java.io.*;
import java.util.*;
import java.util.jar.*;

public class MyJVMTest_14522 {

    static String e = "R xvuOBuP`";

    String getPathForDirEntry(String e) {
        return e.replace(".", File.separator) + ".java";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14522().getPathForDirEntry(e));
    }
}
