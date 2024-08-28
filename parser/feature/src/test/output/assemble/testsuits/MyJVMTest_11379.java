import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;

public class MyJVMTest_11379 {

    static DataLine line = null;

    static long delayMS = 0;

    static Thread thread = null;

    static Object readyEvent = new Object();

    static Object startEvent = new Object();

    void schedule() {
        synchronized (startEvent) {
            startEvent.notifyAll();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11379().schedule();
    }
}
