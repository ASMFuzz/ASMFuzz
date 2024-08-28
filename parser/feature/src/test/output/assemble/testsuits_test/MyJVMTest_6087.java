import java.io.*;

public class MyJVMTest_6087 {

    static String path = "ok#j<RV^\"t";

    String check(String path) {
        if (!new File(path).exists()) {
            throw new Error("file not found: " + path);
        }
        return path;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6087().check(path);
    }
}
