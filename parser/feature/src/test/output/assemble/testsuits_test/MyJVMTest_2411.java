import javax.sound.midi.MidiDevice;

public class MyJVMTest_2411 {

    static boolean state = false;

    static MidiDevice device = null;

    static boolean failed = true;

    String getStateString(boolean state) {
        return state ? "open" : "closed";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2411().getStateString(state));
    }
}
