import java.io.*;

public class MyJVMTest_4417 {

    void testBigOffsetLength2() throws Exception {
        File file = new File(System.getProperty("test.src"), "ReadFully.java");
        try (FileInputStream in = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(in)) {
            byte[] buffer = new byte[100];
            dis.readFully(buffer, 1, buffer.length);
            throw new RuntimeException("Test testBigOffsetLength2() failed");
        } catch (IndexOutOfBoundsException ignore) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4417().testBigOffsetLength2();
    }
}
