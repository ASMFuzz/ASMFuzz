import java.util.Arrays;

public class MyJVMTest_15455 {

    static int M = 9;

    static int offset = 78327280;

    byte[] initializedBytes(int M, int offset) {
        byte[] bytes = new byte[M + offset];
        for (int i = 0; i < offset; i++) {
            bytes[i] = (byte) i;
        }
        for (int i = offset; i < bytes.length; i++) {
            bytes[i] = (byte) (i - offset);
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15455().initializedBytes(M, offset)));
    }
}
