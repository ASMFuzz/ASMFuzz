import java.util.Arrays;

public class MyJVMTest_8973 {

    static int M = 0;

    static int offset = 0;

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
        System.out.println(Arrays.asList(new MyJVMTest_8973().initializedBytes(M, offset)));
    }
}
