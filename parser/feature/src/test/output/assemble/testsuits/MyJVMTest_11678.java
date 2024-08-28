import javax.sound.midi.MidiDevice;

public class MyJVMTest_11678 {

    static boolean state = true;

    static MidiDevice device = null;

    static boolean failed = true;

    String getStateString(boolean state) {
        return state ? "open" : "closed";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11678().getStateString(state));
    }
}
