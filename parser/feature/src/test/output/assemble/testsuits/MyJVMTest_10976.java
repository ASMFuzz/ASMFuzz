import java.util.Arrays;

public class MyJVMTest_10976 {

    static int length = 1334246169;

    static byte[] SALT = {29,38,-50,-1,18,-73,-97,53,60,39};

    static byte[] PLAIN_TEXT = {-109,96,-111,-102,112,98,-68,-50,-72,79};

    byte[] generateBytes(int length) {
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) (i & 0xff);
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10976().generateBytes(length)));
    }
}
