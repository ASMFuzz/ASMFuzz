import javax.sound.midi.*;
import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_13629 {

    static int velocity = 0;

    static float pitch = 0;

    int noteOff(int velocity) {
        pitch = 0;
        return velocity;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13629().noteOff(velocity);
    }
}
