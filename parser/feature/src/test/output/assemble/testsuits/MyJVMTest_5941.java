import java.util.Arrays;

public class MyJVMTest_5941 {

    static int M = 0;

    byte[] initializedBytes(int M) {
        byte[] bytes = new byte[M];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) i;
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5941().initializedBytes(M)));
    }
}
