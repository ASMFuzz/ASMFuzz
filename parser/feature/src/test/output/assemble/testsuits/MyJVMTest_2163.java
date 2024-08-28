import javax.sound.midi.*;
import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_2163 {

    static MidiChannel channel = null;

    static VoiceStatus voice = new VoiceStatus();

    static int noteNumber = 1;

    static int velocity = 0;

    static float pitch = 0;

    int noteOn(MidiChannel channel, VoiceStatus voice, int noteNumber, int velocity) {
        pitch = noteNumber * 100;
        return noteNumber;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2163().noteOn(channel, voice, noteNumber, velocity);
    }
}
