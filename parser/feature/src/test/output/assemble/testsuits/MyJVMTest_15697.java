import java.io.*;
import java.util.*;

public class MyJVMTest_15697 {

    static Random generator = new Random();

    static int A_NUMBER_NEAR_65535 = 60000;

    static int MAX_CORRUPTIONS_PER_CYCLE = 3;

    void writeAndReadAString() throws Exception {
        int length = generator.nextInt(A_NUMBER_NEAR_65535) + 1;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StringBuffer testBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) testBuffer.append((char) generator.nextInt());
        String testString = testBuffer.toString();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeUTF(testString);
        byte[] testBytes = baos.toByteArray();
        int dataLength = testBytes.length;
        int corruptions = generator.nextInt(MAX_CORRUPTIONS_PER_CYCLE);
        for (int i = 0; i < corruptions; i++) {
            int index = generator.nextInt(dataLength);
            testBytes[index] = (byte) generator.nextInt();
        }
        testBytes[dataLength - 1] = (byte) generator.nextInt();
        testBytes[dataLength - 2] = (byte) generator.nextInt();
        ByteArrayInputStream bais = new ByteArrayInputStream(testBytes);
        DataInputStream dis = new DataInputStream(bais);
        dis.readUTF();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15697().writeAndReadAString();
    }
}
