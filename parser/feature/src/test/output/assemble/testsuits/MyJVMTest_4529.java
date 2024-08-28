import java.io.*;

public class MyJVMTest_4529 {

    static String testPath = "l~ONnV{h&>";

    void createTestDir() throws Exception {
        File testDir = new File("a#b");
        boolean result = testDir.mkdir();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4529().createTestDir();
    }
}
