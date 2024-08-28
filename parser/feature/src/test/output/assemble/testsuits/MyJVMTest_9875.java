import javax.sound.midi.*;
import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_9875 {

    static Receiver recv = null;

    static int channel = -1035234538;

    static int tuningpreset = 1;

    static int tuningbank = 0;

    Receiver sendTuningChange(Receiver recv, int channel, int tuningpreset, int tuningbank) throws InvalidMidiDataException {
        ShortMessage sm1 = new ShortMessage();
        sm1.setMessage(ShortMessage.CONTROL_CHANGE, channel, 0x64, 04);
        ShortMessage sm2 = new ShortMessage();
        sm2.setMessage(ShortMessage.CONTROL_CHANGE, channel, 0x65, 00);
        ShortMessage sm3 = new ShortMessage();
        sm3.setMessage(ShortMessage.CONTROL_CHANGE, channel, 0x06, tuningbank);
        ShortMessage sm4 = new ShortMessage();
        sm4.setMessage(ShortMessage.CONTROL_CHANGE, channel, 0x60, 0x7F);
        ShortMessage sm5 = new ShortMessage();
        sm5.setMessage(ShortMessage.CONTROL_CHANGE, channel, 0x61, 0x7F);
        ShortMessage sm6 = new ShortMessage();
        sm6.setMessage(ShortMessage.CONTROL_CHANGE, channel, 0x64, 03);
        ShortMessage sm7 = new ShortMessage();
        sm7.setMessage(ShortMessage.CONTROL_CHANGE, channel, 0x65, 00);
        ShortMessage sm8 = new ShortMessage();
        sm8.setMessage(ShortMessage.CONTROL_CHANGE, channel, 0x06, tuningpreset);
        ShortMessage sm9 = new ShortMessage();
        sm9.setMessage(ShortMessage.CONTROL_CHANGE, channel, 0x60, 0x7F);
        ShortMessage sm10 = new ShortMessage();
        sm10.setMessage(ShortMessage.CONTROL_CHANGE, channel, 0x61, 0x7F);
        recv.send(sm1, -1);
        recv.send(sm2, -1);
        recv.send(sm3, -1);
        recv.send(sm4, -1);
        recv.send(sm5, -1);
        recv.send(sm6, -1);
        recv.send(sm7, -1);
        recv.send(sm8, -1);
        recv.send(sm9, -1);
        recv.send(sm10, -1);
        return recv;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9875().sendTuningChange(recv, channel, tuningpreset, tuningbank);
    }
}
