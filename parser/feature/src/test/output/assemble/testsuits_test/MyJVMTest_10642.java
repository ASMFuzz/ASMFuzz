import java.io.*;

public class MyJVMTest_10642 {

    void testDriveLetter() throws Exception {
        String path = new File("c:/").getCanonicalPath();
        if (path.length() > 3)
            throw new RuntimeException("Drive letter incorrectly represented");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10642().testDriveLetter();
    }
}
