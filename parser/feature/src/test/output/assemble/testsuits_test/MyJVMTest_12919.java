import java.util.Arrays;

public class MyJVMTest_12919 {

    static byte[] E1000G0IPV6ADDRESS = { (byte) 0xfe, (byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x02, (byte) 0x1b, (byte) 0x24, (byte) 0xff, (byte) 0xfe, (byte) 0xbd, (byte) 0xf2, (byte) 0x9c };

    byte[] getAddress() {
        return E1000G0IPV6ADDRESS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12919().getAddress()));
    }
}
