import java.io.*;

public class MyJVMTest_14 {

    static String testPath = "O#8>AfMu&W";

    void eraseTestDir() throws Exception {
        File classFile = new File("a#b/Hello.class");
        classFile.delete();
        File testDir = new File("a#b");
        testDir.delete();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14().eraseTestDir();
    }
}
