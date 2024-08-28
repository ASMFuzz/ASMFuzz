import java.io.*;
import java.util.*;

public class MyJVMTest_8282 {

    static String fileName = "c@D.ht>(~P";

    PrintWriter openFile(String fileName) {
        File f = new File(fileName);
        File baseDir = f.getParentFile();
        if (baseDir != null && baseDir.exists() == false) {
            baseDir.mkdirs();
        }
        try {
            return new PrintWriter(new FileWriter(f), true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8282().openFile(fileName));
    }
}
