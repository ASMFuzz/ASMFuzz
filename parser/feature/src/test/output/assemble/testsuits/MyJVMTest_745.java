import java.util.Arrays;

public class MyJVMTest_745 {

    static byte[] LOOPBACKIPV6ADDRESS = { (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01 };

    byte[] getAddress() {
        return LOOPBACKIPV6ADDRESS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_745().getAddress()));
    }
}
