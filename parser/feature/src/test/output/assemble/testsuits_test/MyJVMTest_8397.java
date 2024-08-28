import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;

public class MyJVMTest_8397 {

    static byte[] buffer = new byte[16384];

    static int successfulTests = 0;

    void checkBufferSDL() throws Exception {
        successfulTests++;
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != ((byte) (i % 128))) {
                throw new Exception("Buffer was changed by SourceDataLine.write()!. Test FAILED");
            }
        }
        System.out.println("  -> passed for this line");
        System.out.println("");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8397().checkBufferSDL();
    }
}
