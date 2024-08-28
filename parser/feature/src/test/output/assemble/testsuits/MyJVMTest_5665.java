import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;

public class MyJVMTest_5665 {

    static String s = "8[KtPi/(}G";

    static DataLine line = null;

    static long delayMS = -9223372036854775808L;

    static Thread thread = null;

    static Object readyEvent = new Object();

    String log(String s) {
        System.out.println(s);
        System.out.flush();
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5665().log(s);
    }
}
