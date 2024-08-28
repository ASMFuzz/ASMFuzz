import javax.sound.midi.*;
import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_11415 {

    static MidiChannel channel = null;

    static VoiceStatus voice = new VoiceStatus();

    static int noteNumber = 0;

    static int velocity = 4;

    static float pitch = 0;

    int noteOn(MidiChannel channel, VoiceStatus voice, int noteNumber, int velocity) {
        pitch = noteNumber * 100;
        return noteNumber;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11415().noteOn(channel, voice, noteNumber, velocity);
    }
}
