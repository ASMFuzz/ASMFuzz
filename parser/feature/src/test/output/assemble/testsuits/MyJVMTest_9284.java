import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_9284 {

    static byte[] data = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };

    static File inFile = null;

    void writeToInFile() throws IOException {
        FileOutputStream out = new FileOutputStream(inFile);
        out.write(data);
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9284().writeToInFile();
    }
}
