import java.util.Arrays;

public class MyJVMTest_2141 {

    static byte[] ct = { -43, 74, 58, -105, 89, 127, 45, 13, 9, -102 };

    byte[] corruptGCM(byte[] ct) {
        ct[ct.length - 1] = (byte) (ct[ct.length - 1] + 1);
        return ct;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2141().corruptGCM(ct)));
    }
}
