import javax.sound.sampled.*;
import com.sun.media.sound.*;
import javax.sound.midi.Instrument;

public class MyJVMTest_8706 {

    Instrument[] getInstruments() {
        Instrument ins = new Instrument(null, null, null, null) {

            public Object getData() {
                return null;
            }
        };
        return new Instrument[] { ins };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8706().getData());
    }
}
