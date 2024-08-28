import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;

public class MyJVMTest_16925 {

    static DataLine line = null;

    static long delayMS = 0;

    static Thread thread = null;

    static Object readyEvent = new Object();

    int getBufferOffset(DataLine line) {
        return Integer.MAX_VALUE - 4096;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16925().getBufferOffset(line));
    }
}
