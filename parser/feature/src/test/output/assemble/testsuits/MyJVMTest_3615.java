import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;

public class MyJVMTest_3615 {

    static byte[] buffer = new byte[5000000];

    static DataLine line = null;

    static long delayMS = 0;

    static Thread thread = null;

    static Object readyEvent = new Object();

    int getBufferOffset(DataLine line) {
        return buffer.length / 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3615().getBufferOffset(line));
    }
}
