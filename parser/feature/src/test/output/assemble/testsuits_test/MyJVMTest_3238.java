import javax.sound.sampled.AudioFormat;

public class MyJVMTest_3238 {

    static AudioFormat format = null;

    static int newBits = -1085954608;

    AudioFormat getOtherBits(AudioFormat format, int newBits) {
        boolean isSigned = format.getEncoding().equals(AudioFormat.Encoding.PCM_SIGNED);
        return new AudioFormat(format.getSampleRate(), newBits, format.getChannels(), isSigned, (newBits > 8) ? format.isBigEndian() : false);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3238().getOtherBits(format, newBits));
    }
}
