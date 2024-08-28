import java.util.Arrays;

public class MyJVMTest_3610 {

    static int[] type = { 7, -175298470, 0, 1613559649, -766744924, 3, 4, 0, 4, 3 };

    static int rate = 1;

    static int channel = 0;

    static long size = -9223372036854775808L;

    byte[] createHeader(final int[] type, final int rate, final int channel, final long size) {
        final int frameSize = ((type[1] + 7) / 8) * channel;
        return new byte[] { 0x52, 0x49, 0x46, 0x46, -1, -1, -1, -1, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6d, 0x74, 0x20, 40, 0, 0, 0, (byte) (type[0]), (byte) (type[0] >> 8), (byte) (channel), (byte) (channel >> 8), (byte) (rate), (byte) (rate >> 8), (byte) (rate >> 16), (byte) (rate >> 24), 1, 0, 0, 0, (byte) (frameSize), (byte) (frameSize >> 8), (byte) type[1], 0, 22, 0, 8, 0, 0, 0, 0, 0, 0x3, 0x0, 0x0, 0x0, 0x0, 0x0, 0x10, 0, (byte) 0x80, 0x0, 0x0, (byte) 0xaa, 0x0, 0x38, (byte) 0x9b, 0x71, 0x64, 0x61, 0x74, 0x61, (byte) (size), (byte) (size >> 8), (byte) (size >> 16), (byte) (size >> 24), 0, 0, 0, 0, 0 };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3610().createHeader(type, rate, channel, size)));
    }
}
