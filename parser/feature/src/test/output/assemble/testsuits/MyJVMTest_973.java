import javax.sound.midi.MidiDevice;

public class MyJVMTest_973 {

    MidiDevice getDevice() {
        return device;
    }

    static MidiDevice device = null;

    static boolean failed = true;

    void closeDevice() {
        getDevice().close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_973().closeDevice();
    }
}
