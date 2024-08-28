import javax.sound.sampled.AudioFormat;
import org.omg.IOP.Encoding;

public class MyJVMTest_17191 {

    static short formatParam1Param1 = -32768;

    static byte formatParam1Param2 = 74;

    static byte formatParam1Param3 = 0;

    static Encoding formatParam1 = new Encoding(formatParam1Param1, formatParam1Param2, formatParam1Param3);

    static float formatParam2 = 0.32794362f;

    static int formatParam3 = 854;

    static int formatParam4 = 475;

    static int formatParam5 = 718;

    static float formatParam6 = 0.87699145f;

    static boolean formatParam7 = true;

    static AudioFormat format = new AudioFormat(formatParam1, formatParam2, formatParam3, formatParam4, formatParam5, formatParam6, formatParam7);

    static int newChannels = 2;

    AudioFormat getOtherChannels(AudioFormat format, int newChannels) {
        int newFrameSize;
        if (newChannels <= 0 || format.getChannels() <= 0 || format.getFrameSize() <= 0) {
            newFrameSize = -1;
        } else {
            newFrameSize = format.getFrameSize() / format.getChannels() * newChannels;
        }
        return new AudioFormat(format.getEncoding(), format.getSampleRate(), format.getSampleSizeInBits(), newChannels, newFrameSize, format.getFrameRate(), format.isBigEndian());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17191().getOtherChannels(format, newChannels));
    }
}
