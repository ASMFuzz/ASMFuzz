import javax.sound.sampled.AudioFormat;
import org.omg.IOP.Encoding;

public class MyJVMTest_7642 {

    static Encoding formatParam1 = new Encoding();

    static float formatParam2 = Float.NaN;

    static int formatParam3 = 911;

    static int formatParam4 = 101;

    static int formatParam5 = 937;

    static float formatParam6 = 0f;

    static boolean formatParam7 = false;

    static AudioFormat format = new AudioFormat(formatParam1, formatParam2, formatParam3, formatParam4, formatParam5, formatParam6, formatParam7);

    static int newChannels = 0;

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
        System.out.println(new MyJVMTest_7642().getOtherChannels(format, newChannels));
    }
}
