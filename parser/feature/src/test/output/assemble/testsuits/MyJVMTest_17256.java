import javax.sound.sampled.AudioFormat;

public class MyJVMTest_17256 {

    static byte[] buffer = new byte[16384];

    void checkBufferClip() throws Exception {
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != (i % 128)) {
                throw new Exception("Buffer was changed by Clip.open()!. Test FAILED");
            }
        }
        System.out.println("  -> passed for this clip");
        System.out.println("");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17256().checkBufferClip();
    }
}
