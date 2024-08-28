import javax.sound.sampled.AudioFormat;

public class MyJVMTest_12557 {

    static float formatParam1 = 0.911316f;

    static int formatParam2 = 6;

    static int formatParam3 = 920;

    static boolean formatParam4 = false;

    static boolean formatParam5 = false;

    static AudioFormat format = new AudioFormat(formatParam1, formatParam2, formatParam3, formatParam4, formatParam5);

    static int newBits = 0;

    AudioFormat getOtherBits(AudioFormat format, int newBits) {
        boolean isSigned = format.getEncoding().equals(AudioFormat.Encoding.PCM_SIGNED);
        return new AudioFormat(format.getSampleRate(), newBits, format.getChannels(), isSigned, (newBits > 8) ? format.isBigEndian() : false);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12557().getOtherBits(format, newBits));
    }
}
