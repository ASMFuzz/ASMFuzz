import java.util.Arrays;

public class MyJVMTest_10635 {

    static byte bits = -128;

    static int rate = 4;

    static int channel = 1688314272;

    static long frameLength = 9223372036854775807L;

    static int DOUBLE_MANTISSA_LENGTH = 52;

    static int DOUBLE_EXPONENT_LENGTH = 11;

    static long DOUBLE_SIGN_MASK = 0x8000000000000000L;

    static long DOUBLE_EXPONENT_MASK = 0x7FF0000000000000L;

    static long DOUBLE_MANTISSA_MASK = 0x000FFFFFFFFFFFFFL;

    static int DOUBLE_EXPONENT_OFFSET = 1023;

    static int EXTENDED_EXPONENT_OFFSET = 16383;

    static int EXTENDED_MANTISSA_LENGTH = 63;

    static int EXTENDED_EXPONENT_LENGTH = 15;

    static long EXTENDED_INTEGER_MASK = 0x8000000000000000L;

    byte[] createHeader(final byte bits, final int rate, final int channel, final long frameLength) {
        long doubleBits = Double.doubleToLongBits(rate);
        long sign = (doubleBits & DOUBLE_SIGN_MASK) >> (DOUBLE_EXPONENT_LENGTH + DOUBLE_MANTISSA_LENGTH);
        long doubleExponent = (doubleBits & DOUBLE_EXPONENT_MASK) >> DOUBLE_MANTISSA_LENGTH;
        long doubleMantissa = doubleBits & DOUBLE_MANTISSA_MASK;
        long extendedExponent = doubleExponent - DOUBLE_EXPONENT_OFFSET + EXTENDED_EXPONENT_OFFSET;
        long extendedMantissa = doubleMantissa << (EXTENDED_MANTISSA_LENGTH - DOUBLE_MANTISSA_LENGTH);
        long extendedSign = sign << EXTENDED_EXPONENT_LENGTH;
        short extendedBits79To64 = (short) (extendedSign | extendedExponent);
        long extendedBits63To0 = EXTENDED_INTEGER_MASK | extendedMantissa;
        return new byte[] { 0x46, 0x4f, 0x52, 0x4d, (byte) (frameLength >> 24), (byte) (frameLength >> 16), (byte) (frameLength >> 8), (byte) frameLength, 0x41, 0x49, 0x46, 0x46, 0x43, 0x4f, 0x4d, 0x4d, 0, 0, 0, 18, (byte) (channel >> 8), (byte) channel, (byte) (frameLength >> 24), (byte) (frameLength >> 16), (byte) (frameLength >> 8), (byte) (frameLength), (byte) (bits >> 8), (byte) (bits), (byte) (extendedBits79To64 >> 8), (byte) extendedBits79To64, (byte) (extendedBits63To0 >> 56), (byte) (extendedBits63To0 >> 48), (byte) (extendedBits63To0 >> 40), (byte) (extendedBits63To0 >> 32), (byte) (extendedBits63To0 >> 24), (byte) (extendedBits63To0 >> 16), (byte) (extendedBits63To0 >> 8), (byte) extendedBits63To0, 0x53, 0x53, 0x4e, 0x44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10635().createHeader(bits, rate, channel, frameLength)));
    }
}
