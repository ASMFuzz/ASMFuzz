import javax.sound.sampled.AudioFormat;

public class MyJVMTest_16251 {

    static float formatParam1 = Float.POSITIVE_INFINITY;

    static int formatParam2 = 720;

    static int formatParam3 = 172;

    static boolean formatParam4 = false;

    static boolean formatParam5 = true;

    static AudioFormat format = new AudioFormat(formatParam1, formatParam2, formatParam3, formatParam4, formatParam5);

    AudioFormat getOtherEndianOrSign(AudioFormat format) {
        AudioFormat.Encoding newEnc = null;
        boolean newEndian = format.isBigEndian();
        boolean isSigned = format.getEncoding().equals(AudioFormat.Encoding.PCM_SIGNED);
        boolean isUnsigned = format.getEncoding().equals(AudioFormat.Encoding.PCM_UNSIGNED);
        if ((isSigned || isUnsigned) && format.getSampleSizeInBits() > 0) {
            if (format.getSampleSizeInBits() == 8) {
                if (isSigned) {
                    newEnc = AudioFormat.Encoding.PCM_UNSIGNED;
                } else {
                    newEnc = AudioFormat.Encoding.PCM_SIGNED;
                }
            } else {
                newEnc = format.getEncoding();
                newEndian = !newEndian;
            }
            if (newEnc != null) {
                return new AudioFormat(newEnc, format.getSampleRate(), format.getSampleSizeInBits(), format.getChannels(), format.getFrameSize(), format.getFrameRate(), newEndian);
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16251().getOtherEndianOrSign(format));
    }
}
