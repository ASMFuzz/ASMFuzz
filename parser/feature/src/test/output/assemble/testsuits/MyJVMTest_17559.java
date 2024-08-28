import java.io.*;
import java.util.*;
import javax.tools.*;

public class MyJVMTest_17559 {

    static String path = " z+yv(6hjZ";

    File createTempFile(String path) throws IOException {
        File f = new File(path);
        try (FileWriter out = new FileWriter(f)) {
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17559().createTempFile(path));
    }
}
