import javax.sound.midi.MidiDevice;

public class MyJVMTest_10159 {

    MidiDevice getDevice() {
        return device;
    }

    static MidiDevice device = null;

    static boolean failed = false;

    void closeDevice() {
        getDevice().close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10159().closeDevice();
    }
}
