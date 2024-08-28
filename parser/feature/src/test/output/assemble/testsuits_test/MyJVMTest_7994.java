import java.io.*;
import java.util.*;
import javax.tools.*;

public class MyJVMTest_7994 {

    static String path = "A\"+m`Mjc/Y";

    File createTempFile(String path) throws IOException {
        File f = new File(path);
        try (FileWriter out = new FileWriter(f)) {
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7994().createTempFile(path));
    }
}
