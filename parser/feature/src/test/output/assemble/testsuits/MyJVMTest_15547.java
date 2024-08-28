import java.io.*;

public class MyJVMTest_15547 {

    static String path = "07Wv:w&XQy";

    String check(String path) {
        if (!new File(path).exists()) {
            throw new Error("file not found: " + path);
        }
        return path;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15547().check(path);
    }
}
