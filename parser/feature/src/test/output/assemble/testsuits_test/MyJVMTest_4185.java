import java.io.*;

public class MyJVMTest_4185 {

    void testCreateExistingDir() throws IOException {
        File tmpFile = new File("hugo");
        if (tmpFile.exists() && !tmpFile.delete())
            throw new RuntimeException("Cannot delete " + tmpFile);
        if (!tmpFile.mkdir())
            throw new RuntimeException("Cannot create dir " + tmpFile);
        if (!tmpFile.exists())
            throw new RuntimeException("Cannot see created dir " + tmpFile);
        if (tmpFile.createNewFile())
            throw new RuntimeException("Should fail to create file " + tmpFile);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4185().testCreateExistingDir();
    }
}
