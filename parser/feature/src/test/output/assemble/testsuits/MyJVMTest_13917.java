import java.io.*;

public class MyJVMTest_13917 {

    static String testPath = "D(mZbX5&~J";

    void createTestDir() throws Exception {
        File testDir = new File("a#b");
        boolean result = testDir.mkdir();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13917().createTestDir();
    }
}
