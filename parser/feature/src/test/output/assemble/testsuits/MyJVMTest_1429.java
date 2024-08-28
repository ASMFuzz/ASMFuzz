import java.io.*;

public class MyJVMTest_1429 {

    void testDriveLetter() throws Exception {
        String path = new File("c:/").getCanonicalPath();
        if (path.length() > 3)
            throw new RuntimeException("Drive letter incorrectly represented");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1429().testDriveLetter();
    }
}
