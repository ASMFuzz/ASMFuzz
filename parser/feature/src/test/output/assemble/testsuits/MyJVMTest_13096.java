import java.io.*;

public class MyJVMTest_13096 {

    void testNegativeLength() throws Exception {
        File file = new File(System.getProperty("test.src"), "ReadFully.java");
        try (FileInputStream in = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(in)) {
            byte[] buffer = new byte[100];
            dis.readFully(buffer, 0, -1);
            throw new RuntimeException("Test testNegativeLength() failed");
        } catch (IndexOutOfBoundsException ignore) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13096().testNegativeLength();
    }
}
