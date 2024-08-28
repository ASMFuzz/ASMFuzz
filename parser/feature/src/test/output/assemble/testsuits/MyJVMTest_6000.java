import java.util.Arrays;

public class MyJVMTest_6000 {

    static int M = 5;

    static int offset = -559673342;

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
        System.out.println(Arrays.asList(new MyJVMTest_6000().initializedBytes(M, offset)));
    }
}
