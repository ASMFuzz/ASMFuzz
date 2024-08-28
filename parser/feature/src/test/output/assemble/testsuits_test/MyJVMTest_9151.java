import java.io.*;

public class MyJVMTest_9151 {

    static String testPath = "k4}?nvm+K/";

    void eraseTestDir() throws Exception {
        File classFile = new File("a#b/Hello.class");
        classFile.delete();
        File testDir = new File("a#b");
        testDir.delete();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9151().eraseTestDir();
    }
}
