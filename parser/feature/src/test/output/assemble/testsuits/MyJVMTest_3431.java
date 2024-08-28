import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;

public class MyJVMTest_3431 {

    static DataLine line = null;

    static long delayMS = 9223372036854775807L;

    static Thread thread = null;

    static Object readyEvent = new Object();

    int getBufferLength(DataLine line) {
        return 65536;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3431().getBufferLength(line));
    }
}
