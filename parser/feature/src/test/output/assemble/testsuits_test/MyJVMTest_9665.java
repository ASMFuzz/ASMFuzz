import java.io.*;
import java.util.*;

public class MyJVMTest_9665 {

    static String path = "x[$d-\\8L#a";

    static String body = ".Q~H-y_T|K";

    File writeFile(String path, String body) throws IOException {
        File f = new File(path);
        FileWriter out = new FileWriter(f);
        try {
            out.write(body);
        } finally {
            out.close();
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9665().writeFile(path, body));
    }
}
