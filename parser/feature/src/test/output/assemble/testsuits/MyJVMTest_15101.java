import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;

public class MyJVMTest_15101 {

    static String s = "WeM$=BZ%mH";

    static DataLine line = null;

    static long delayMS = 0;

    static Thread thread = null;

    static Object readyEvent = new Object();

    String log(String s) {
        System.out.println(s);
        System.out.flush();
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15101().log(s);
    }
}
