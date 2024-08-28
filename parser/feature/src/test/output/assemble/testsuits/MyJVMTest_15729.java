import java.util.Arrays;

public class MyJVMTest_15729 {

    static byte[] type = { -27, 1, 109, -112, -24, -38, 13, 32, 113, -125 };

    static int rate = 8;

    static int channel = 1;

    static long size = 0;

    byte[] createHeader(final byte[] type, final int rate, final int channel, final long size) {
        final int frameSize = ((type[1] + 7) / 8) * channel;
        return new byte[] { 0x52, 0x49, 0x46, 0x46, -1, -1, -1, -1, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6d, 0x74, 0x20, 16, 0, 0, 0, type[0], 0, (byte) (channel), (byte) (channel >> 8), (byte) (rate), (byte) (rate >> 8), (byte) (rate >> 16), (byte) (rate >> 24), 1, 0, 0, 0, (byte) (frameSize), (byte) (frameSize >> 8), type[1], 0, 0x64, 0x61, 0x74, 0x61, (byte) (size), (byte) (size >> 8), (byte) (size >> 16), (byte) (size >> 24), 0, 0, 0, 0, 0 };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15729().createHeader(type, rate, channel, size)));
    }
}
