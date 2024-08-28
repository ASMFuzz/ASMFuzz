import java.io.*;

public class MyJVMTest_5875 {

    void testNegativeOffset() throws Exception {
        File file = new File(System.getProperty("test.src"), "ReadFully.java");
        try (FileInputStream in = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(in)) {
            byte[] buffer = new byte[100];
            dis.readFully(buffer, -1, buffer.length);
            throw new RuntimeException("Test testNegativeOffset() failed");
        } catch (IndexOutOfBoundsException ignore) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5875().testNegativeOffset();
    }
}
