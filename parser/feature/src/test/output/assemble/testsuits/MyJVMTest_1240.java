import java.io.*;

public class MyJVMTest_1240 {

    void testNegativeOffsetZeroLength() throws Exception {
        File file = new File(System.getProperty("test.src"), "ReadFully.java");
        try (FileInputStream in = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(in)) {
            byte[] buffer = new byte[100];
            dis.readFully(buffer, -1, 0);
            throw new RuntimeException("Test testNegativeOffsetZeroLength() failed");
        } catch (IndexOutOfBoundsException ignore) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1240().testNegativeOffsetZeroLength();
    }
}
