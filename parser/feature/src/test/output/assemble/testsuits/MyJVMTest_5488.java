import java.io.*;

public class MyJVMTest_5488 {

    void testBigOffsetLength4() throws Exception {
        File file = new File(System.getProperty("test.src"), "ReadFully.java");
        try (FileInputStream in = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(in)) {
            byte[] buffer = new byte[100];
            dis.readFully(buffer, buffer.length + 1, 0);
            throw new RuntimeException("Test testBigOffsetLength4() failed");
        } catch (IndexOutOfBoundsException ignore) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5488().testBigOffsetLength4();
    }
}
