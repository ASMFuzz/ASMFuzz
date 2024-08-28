import java.io.*;

public class MyJVMTest_7103 {

    void testBigOffsetLength1() throws Exception {
        File file = new File(System.getProperty("test.src"), "ReadFully.java");
        try (FileInputStream in = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(in)) {
            byte[] buffer = new byte[100];
            dis.readFully(buffer, 0, buffer.length + 1);
            throw new RuntimeException("Test testBigOffsetLength1() failed");
        } catch (IndexOutOfBoundsException ignore) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7103().testBigOffsetLength1();
    }
}
