import java.io.*;

public class MyJVMTest_6310 {

    void testBigOffsetLength3() throws Exception {
        File file = new File(System.getProperty("test.src"), "ReadFully.java");
        try (FileInputStream in = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(in)) {
            byte[] buffer = new byte[100];
            dis.readFully(buffer, buffer.length, 1);
            throw new RuntimeException("Test testBigOffsetLength3() failed");
        } catch (IndexOutOfBoundsException ignore) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6310().testBigOffsetLength3();
    }
}
