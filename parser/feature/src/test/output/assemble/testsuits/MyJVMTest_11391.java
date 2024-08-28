import java.util.Arrays;

public class MyJVMTest_11391 {

    static byte[] ct = { -120, 126, -80, -63, -6, 39, -68, -58, 57, 56 };

    byte[] corruptGCM(byte[] ct) {
        ct[ct.length - 1] = (byte) (ct[ct.length - 1] + 1);
        return ct;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11391().corruptGCM(ct)));
    }
}
